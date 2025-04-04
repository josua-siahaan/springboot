

-- ----------------------------
-- Records of MstGroupMenu
-- ----------------------------
SET IDENTITY_INSERT [dbproject].[MstGroupMenu] ON
    ;

INSERT INTO [dbproject].[MstGroupMenu] ([CreatedBy], [CreatedDate], [IDGroup], [ModifiedBy], [ModifiedDate], [Nama], [Deskripsi]) VALUES (N'1', N'2025-03-10 18:32:05.000000', N'1', NULL, NULL, N'User Management', N'Untuk Pengaturan Yang Berkaitan Dengan User')
;

INSERT INTO [dbproject].[MstGroupMenu] ([CreatedBy], [CreatedDate], [IDGroup], [ModifiedBy], [ModifiedDate], [Nama], [Deskripsi]) VALUES (N'1', N'2025-03-10 18:35:13.000000', N'2', NULL, NULL, N'Artikel', N'Group Menu Untuk Default User Setelah Registrasi')
;

SET IDENTITY_INSERT [dbproject].[MstGroupMenu] OFF
    ;



    -- ----------------------------
-- Records of MstMenu
-- ----------------------------
    SET IDENTITY_INSERT [dbproject].[MstMenu] ON
    ;

INSERT INTO [dbproject].[MstMenu] ([CreatedBy], [CreatedDate], [IDGroupMenu], [IDMenu], [ModifiedBy], [ModifiedDate], [NamaMenu], [Path]) VALUES (N'1', N'2025-03-10 18:34:26.000000', N'1', N'1', NULL, NULL, N'Group-Menu', N'/group-menu')
;

INSERT INTO [dbproject].[MstMenu] ([CreatedBy], [CreatedDate], [IDGroupMenu], [IDMenu], [ModifiedBy], [ModifiedDate], [NamaMenu], [Path]) VALUES (N'1', N'2025-03-10 18:34:47.000000', N'1', N'2', NULL, NULL, N'Menu', N'/menu')
;

INSERT INTO [dbproject].[MstMenu] ([CreatedBy], [CreatedDate], [IDGroupMenu], [IDMenu], [ModifiedBy], [ModifiedDate], [NamaMenu], [Path]) VALUES (N'1', N'2025-03-10 18:35:02.000000', N'1', N'3', NULL, NULL, N'Akses', N'/akses')
;

INSERT INTO [dbproject].[MstMenu] ([CreatedBy], [CreatedDate], [IDGroupMenu], [IDMenu], [ModifiedBy], [ModifiedDate], [NamaMenu], [Path]) VALUES (N'1', N'2025-03-10 18:35:13.000000', N'1', N'4', NULL, NULL, N'User', N'/user')
;

INSERT INTO [dbproject].[MstMenu] ([CreatedBy], [CreatedDate], [IDGroupMenu], [IDMenu], [ModifiedBy], [ModifiedDate], [NamaMenu], [Path]) VALUES (N'1', N'2025-03-10 18:35:13.000000', N'2', N'5', NULL, NULL, N'Artikel-1', N'/artikel-1')
;

INSERT INTO [dbproject].[MstMenu] ([CreatedBy], [CreatedDate], [IDGroupMenu], [IDMenu], [ModifiedBy], [ModifiedDate], [NamaMenu], [Path]) VALUES (N'1', N'2025-03-10 18:35:13.000000', N'2', N'6', NULL, NULL, N'Artikel-2', N'/artikel-2')
;

SET IDENTITY_INSERT [dbproject].[MstMenu] OFF
    ;

-- ----------------------------
-- Records of MstAkses
-- ----------------------------
SET IDENTITY_INSERT [dbproject].[MstAkses] ON
    ;

INSERT INTO [dbproject].[MstAkses] ([CreatedBy], [CreatedDate], [IDAkses], [ModifiedBy], [ModifiedDate], [NamaAkses], [Deskripsi]) VALUES (N'1', N'2025-03-10 18:33:19.000000', N'1', NULL, NULL, N'Admin', N'Administrator')
;

INSERT INTO [dbproject].[MstAkses] ([CreatedBy], [CreatedDate], [IDAkses], [ModifiedBy], [ModifiedDate], [NamaAkses], [Deskripsi]) VALUES (N'1', N'2025-03-10 18:33:35.000000', N'2', NULL, NULL, N'Member', N'Default Akses Dari Proses Registrasi')
;

SET IDENTITY_INSERT [dbproject].[MstAkses] OFF
    ;

    -- ----------------------------
-- Records of MapAksesMenu
-- ----------------------------
INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'1')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'2')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'3')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'4')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'5')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'6')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'5')
;

INSERT INTO [dbproject].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'6')
;


-- ----------------------------
-- Records of MstUser
-- ----------------------------
SET IDENTITY_INSERT [dbproject].[MstUser] ON
    ;

INSERT INTO [dbproject].[MstUser] ([IsRegistered], [TanggalLahir], [CreatedBy], [CreatedDate], [IDAkses], [IDUser], [ModifiedBy], [ModifiedDate], [NoHp], [username], [Nama], [OTP], [Password], [Email], [Alamat], [LinkProfilePicture], [ProfilePicture]) VALUES (N'1', N'1995-12-12', N'1', N'2025-03-07 21:41:59.211000', N'1', N'1', N'2', NULL, N'081286111111', N'paul.123', N'Paul Christian Malau', N'$2a$11$s7GIe89MZEBVj0JclLha5ubV5e/iAulQvGDyeaOT2R.x/U3gls34y', N'$2a$11$546ppLHA5lOGkrVXebxk.OPLNkrHrJ27gRgKiM4FOTVneRVzu7IXm', N'poll.chihuy@gmail.com', N'Bogor Bogor Bogor Bogor Bogor Bogor Bogor ', NULL, NULL)
;

SET IDENTITY_INSERT [dbproject].[MstUser] OFF
    ;