package juara.coding.day19.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import juara.coding.day19.config.JwtConfig;
import juara.coding.day19.dto.validation.ValLoginDTO;
import juara.coding.day19.dto.validation.ValRegisDTO;
import juara.coding.day19.dto.validation.ValVerifyOTPRegisDTO;
import juara.coding.day19.model.Akses;
import juara.coding.day19.model.User;
import juara.coding.day19.repos.UserRepo;
import juara.coding.day19.security.BcryptImpl;
import juara.coding.day19.security.Crypto;
import juara.coding.day19.security.JwtUtility;
import juara.coding.day19.util.SendMailOTP;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtUtility jwtUtility;

    private Random random = new Random();

    public ResponseEntity<Object> Login(User user , HttpServletRequest request){
        Optional<User> optUser = userRepo.findByUsername(user.getUsername());
        Map<String, Object> m = new HashMap<>();
        if (!optUser.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username / password salah -01!");
        }

        User userNext = optUser.get();

        if (!userNext.getRegistered()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username / password Salah -02!");
        }

        if (!BcryptImpl.verifyHash(user.getUsername()+user.getPassword(), userNext.getPassword())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username / password Salah -03!");
        }
        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", userNext.getId());
        m1.put("phn", userNext.getNoHp());
        m1.put("ml", userNext.getEmail());
        String token = jwtUtility.doGenerateToken(m1, userNext.getUsername());
        if (JwtConfig.getTokenEncryptEnable().equals("y")){
            token = Crypto.performDecrypt(token);
        }
        m.put("token", token);
        m.put("menu", new ArrayList<>());
        return ResponseEntity.ok().body(m);
    }

    public ResponseEntity<Object> regis(User user, HttpServletRequest request){
        Optional<User> optUser = userRepo.findByUsername(user.getUsername());
        Map<String, Object> m = new HashMap<>();

        int intOtp = random.nextInt(111111,999999);

        if (!optUser.isPresent()){
            user.setPassword(BcryptImpl.hash(user.getUsername()+user.getPassword()));
            user.setOtp(BcryptImpl.hash(String.valueOf(intOtp)));
//            Akses akses = new Akses();
//            akses.setId(2L);
//            user.setAkses(akses);
            userRepo.save(user);
            m.put("otp", intOtp);
            m.put("email", user.getEmail());
        }
        else {
            User userNext = optUser.get();
            if (userNext.getRegistered()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username sudah digunakan, Silahkan langsung melakukan login !! - AUT00FV011");
            }
            Optional<User> optCheckEmailUser = userRepo.findByEmailAndIsRegistered(user.getEmail(), true);
            if (optCheckEmailUser.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Telah digunakan - AUT00FV012");
            }
            Optional<User> optCheckPhoneUser = userRepo.findByNoHpAndIsRegistered(user.getNoHp(), true);
            if (optCheckPhoneUser.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No. HP Telah digunakan - AUT00FV013");
            }
            userNext.setOtp(BcryptImpl.hash(String.valueOf(intOtp)));
            userNext.setEmail(user.getEmail());
            userNext.setNoHp(user.getNoHp());
            userNext.setAlamat(user.getAlamat());
            userNext.setNama(user.getNama());
            userNext.setTanggalLahir(user.getTanggalLahir());
            userNext.setModifiedBy(userNext.getId());
            userNext.setPassword(user.getUsername()+user.getPassword());
            m.put("otp", intOtp);
            m.put("email", user.getEmail());

            if (optUser.isPresent()){
                SendMailOTP.verifyRegisOTP("Verifikasi OTP Registrasi",
                        user.getNama(),
                        user.getEmail(),
                        String.valueOf(intOtp));
            }
        }
        return ResponseEntity.ok().body(m);
    }


    public ResponseEntity<Object> verifyRegis(User user, HttpServletRequest request){
        Optional<User> optUser = userRepo.findByEmail(user.getEmail());
        if (!optUser.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data tidak falid");
        }

        User userNext = optUser.get();
        if (!BcryptImpl.verifyHash(user.getOtp(), userNext.getOtp())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OTP tidak falid, Cek Email Anda");
        }

        userNext.setRegistered(true);
        userNext.setModifiedBy(userNext.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Registrasi Berhasil");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>  opUser = userRepo.findByUsername(username);
        if(!opUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        User user = opUser.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),user.getAuthorities());
    }

    public User convertToEntity(ValRegisDTO valRegisDTO){
        return modelMapper.map(valRegisDTO, User.class);
    }

    public User convertToEntity(ValVerifyOTPRegisDTO valVerifyOTPRegisDTO){
        return modelMapper.map(valVerifyOTPRegisDTO, User.class);
    }

    public User convertToEntity(ValLoginDTO valLoginDTO){
        return modelMapper.map(valLoginDTO, User.class);
    }
}
