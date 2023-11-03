# Sistem Perpustakaan

## Kelompok 19
- **Nama:** Siti Nikmatul Ula
  - **2209116059** 

- **Nama:** Kalsum Burhani Putri
  - **2209116095**
    
## Deskripsi Project
Sistem Perpustakaan ini adalah sebuah proyek aplikasi Java yang bertujuan untuk menyederhanakan manajemen perpustakaan dengan dua peran utama, yaitu Anggota dan Petugas Perpustakaan. Aplikasi ini memungkinkan Anggota untuk dengan mudah menjelajahi katalog buku perpustakaan, melakukan peminjaman, dan pengembalian buku dengan berbagai fitur yang telah disiapkan.

Salah satu fitur unik dalam sistem ini adalah penerapan denda otomatis ketika Anggota mengembalikan buku terlambat. Denda tetap sebesar 10.000 akan secara otomatis dikenakan ketika anggota melewatkan tenggat waktu pengembalian sesuai dengan kebijakan perpustakaan. Ini membantu perpustakaan dalam memastikan kepatuhan terhadap jadwal pengembalian buku.

Sementara itu, Petugas Perpustakaan memiliki peran yang lebih luas dalam manajemen buku. Mereka memiliki kemampuan untuk dengan mudah menambahkan buku baru ke dalam koleksi perpustakaan (Create), memperbarui informasi buku yang sudah ada (Update), dan menghapus buku yang sudah tidak tersedia (Delete). Selain itu, mereka juga dapat memantau keterlambatan pengembalian buku oleh anggota dan mengenakan denda sesuai dengan kebijakan perpustakaan (Create)

## Flowchart
![fwfixxxxxxxxxxxxxx](https://github.com/sittii/PA-PBO/assets/123925640/c402c090-8989-487f-bc9b-907820e46682)

## ERD
![logicalfixparahh](https://github.com/sittii/PA-PBO/assets/123925640/d2e2f712-bc29-4b93-8001-6d0dc0d225f8)

## Hirarki Kelas
![hffffffffffffffffffff](https://github.com/sittii/PA-PBO/assets/123925640/f332d345-3318-41df-9eb8-fef43e921f05)

## Penjelasan Coding
![image](https://github.com/sittii/PA-PBO/assets/123925640/2c996955-9174-44f6-8754-d0f03fd259af)

Package `projectpapbodb` digunakan untuk menyimpan file koneksi database mysql, dan file utama program

![image](https://github.com/sittii/PA-PBO/assets/123925640/30386da8-f49a-4779-8e40-a3339969a0e2)

Bagian ini merupakan bagian utama dari program Java yang mengembangkan aplikasi dengan antarmuka pengguna (GUI). Dalam program ini, kelas Formsplash digunakan untuk menampilkan layar pembuka splash screen, dan kelas FormLogin digunakan untuk tampilan login. Ketika program dijalankan, splash screen ditampilkan terlebih dahulu dengan efek loading yang disimulasikan, lalu setelah loading mencapai 100%, splash screen ditutup dan FormLogin ditampilkan untuk masuk ke menu utama. Ini memberikan pengguna pengalaman awal yang menarik sebelum mengakses menu utama.

![image](https://github.com/sittii/PA-PBO/assets/123925640/2860cb5c-a0ab-4074-9d0c-4a207c70b021)

![image](https://github.com/sittii/PA-PBO/assets/123925640/acff83c0-0101-48d6-aaaf-565b71bc111b)

Kode tersebut merupakan bagian dari sebuah aplikasi Java yang digunakan untuk mengelola koneksi dengan database MySQL. Kelas ConnectionDatabase ini memiliki metode openConnection yang digunakan untuk membuka koneksi ke database dengan menggunakan parameter seperti host, nama database, username, dan password yang telah ditentukan. Kemudian, terdapat metode closeConnection yang digunakan untuk menutup semua elemen terkait koneksi, seperti resultSet, statement, preparedStatement, dan connection. Jika terjadi kesalahan dalam koneksi database, kelas ini juga memiliki metode displayErrors untuk menampilkan pesan kesalahan. 

![image](https://github.com/sittii/PA-PBO/assets/123925640/72ae4561-214c-4762-aaf2-2c00e3a5c3cb)

Paket `projectpapbodb.objek` digunakan untuk mengelompokkan semua kelas yang berkaitan dengan objek atau entitas dalam proyek, termasuk atribut dan metode yang terkait dengan objek tersebut.

![image](https://github.com/sittii/PA-PBO/assets/123925640/0273f7a3-638f-457f-bff6-cb92bd9d0994)

![image](https://github.com/sittii/PA-PBO/assets/123925640/9c8b2b4c-3db1-4267-89fd-187a1a58039a)

![image](https://github.com/sittii/PA-PBO/assets/123925640/5c337353-cb49-461d-a53b-5aec9f8e2481)

![image](https://github.com/sittii/PA-PBO/assets/123925640/ec633a03-c463-4bd7-b1ad-4d291bfea811)

![image](https://github.com/sittii/PA-PBO/assets/123925640/7ff78bf3-18eb-440a-b853-07d27e328787)

![image](https://github.com/sittii/PA-PBO/assets/123925640/98ea39b8-5c59-4d1c-8d65-9195f015249c)

Pada class user ini implementasi digunakan dalam sebuah manajemen pengguna (user) di sistem perpustakaan. Class ini mengelola informasi pengguna seperti nama, username, password, dan peran (role). Terdapat metode "generateNextUserCode" yang digunakan untuk menghasilkan kode pengguna baru, metode "tambah" untuk menyimpan data pengguna ke database, dan metode "login" untuk melakukan autentikasi pengguna berdasarkan username dan password. 

![image](https://github.com/sittii/PA-PBO/assets/123925640/4909ec56-eb79-4616-a1aa-246c5e833e8d)

![image](https://github.com/sittii/PA-PBO/assets/123925640/7c631790-f3ef-4dc4-984a-d74ecc911805)

Pada class anggota ini merupakan turunan subclass dari class user, class anggota ini memiliki atribut tambahan yaitu alamat email. Selain itu, terdapat metode tambah yang mengoverride metode yang sama dalam kelas User untuk menambahkan data anggota ke tabel Anggota dalam database. Dalam metode tambah, koneksi ke database dibuka, dan sebuah pernyataan SQL INSERT digunakan untuk memasukkan data anggota ke dalam tabel.

![image](https://github.com/sittii/PA-PBO/assets/123925640/9d70dc18-49ed-463a-8d83-572b305f485b)

![image](https://github.com/sittii/PA-PBO/assets/123925640/e7541a29-20ac-49d8-8f25-f7cb5acb4757)

![image](https://github.com/sittii/PA-PBO/assets/123925640/632a343e-ba4b-4099-a377-fab843ba053b)

![image](https://github.com/sittii/PA-PBO/assets/123925640/6d6850b3-6728-4c3a-9570-8b8a0a62c462)

![image](https://github.com/sittii/PA-PBO/assets/123925640/599fa6a6-5e85-41d6-b196-cc0ae6965cd9)

Pada kelas Buku, implementasi ini digunakan dalam proyek Java untuk mengelola data buku dan berinteraksi dengan database. Kelas Buku memiliki atribut seperti kodeBuku, judulBuku, penulis, stok, dan kodeUser yang digunakan untuk menyimpan informasi terkait buku. Selain itu, kelas ini memiliki metode-metode seperti tambahBuku, updateBuku, dan deleteBuku, yang memungkinkan penambahan, pembaruan, atau penghapusan data buku dalam tabel database. Metode generateNextBukuCode digunakan untuk menghasilkan kode buku secara otomatis dan berurut, yang selanjutnya digunakan dalam operasi CRUD (Create, Read, Update, Delete) yang terhubung dengan database.

![image](https://github.com/sittii/PA-PBO/assets/123925640/339304ba-0c8a-400b-b2cb-d5d99d2f74b7)

![image](https://github.com/sittii/PA-PBO/assets/123925640/0bfb1777-57d9-4802-add5-6209f76cd65b)

Pada class denda, kode ini merupakan implementasi class denda yang digunakan untuk mengelola data denda terkait pengembalian buku dalam perpustakaan. Kelas ini memiliki beberapa atribut seperti kodedenda, kodepinjam, kodebuku, kodeuser, dan kodeuseranggota yang digunakan untuk menyimpan informasi denda yang terkait dengan suatu transaksi peminjaman buku tertentu. Metode simpanDenda digunakan untuk mencatat dan mengonfirmasi pembayaran denda.

![image](https://github.com/sittii/PA-PBO/assets/123925640/c200388a-ed15-412c-895d-424fe8bd105f)

![image](https://github.com/sittii/PA-PBO/assets/123925640/0720162a-42c6-4401-9048-6e1dedffcf49)

![image](https://github.com/sittii/PA-PBO/assets/123925640/87bd2c05-f950-435f-8c9a-1fa22597f4be)

![image](https://github.com/sittii/PA-PBO/assets/123925640/dd9a06b1-a536-4853-bac7-62a0cb00bcd9)

![image](https://github.com/sittii/PA-PBO/assets/123925640/c4cb4c47-be74-4d28-ac4b-8ead2b6608af)

Pada class peminjaman buku ini implementasi peminjaman buku ke dalam proyek java yang digunakan untuk penyimpanan data peminjaman, pengurangan stok buku, dan pembaruan status peminjaman. Class ini memiliki hubungan seperti kodepinjam, tglpinjam, statuspinjam, tglkembali, kodeuser, dan kodebuku. Terdapat pula beberapa metode, seperti generateNextPinjamCode untuk menghasilkan kode peminjaman baru, simpan Peminjaman untuk menyimpan data peminjaman ke database, kurangi Stok Buku untuk mengurangi stok buku setelah peminjaman, dan simpan Pengembalian untuk mengupdate status peminjaman buku.

![image](https://github.com/sittii/PA-PBO/assets/123925640/83e6d834-b8de-46e2-b24f-3602dc851e15)

![image](https://github.com/sittii/PA-PBO/assets/123925640/258cec44-b86d-45a7-806d-b9a3fa7f819b)

![image](https://github.com/sittii/PA-PBO/assets/123925640/91e75ef3-e56c-4d7e-b9ca-ab9e0d4f174f)

![image](https://github.com/sittii/PA-PBO/assets/123925640/6fbad41d-9788-420f-8a10-f740109eccdb)

Pada class pengembalian buku ini implementasi pengembalian buku digunakan untuk mengelola pengembalian buku. Class ini memiliki properti kodeuser, kodepinjam, dan kodebuku untuk menyimpan informasi terkait pengembalian buku. 

![image](https://github.com/sittii/PA-PBO/assets/123925640/32af3795-0b01-4741-b322-150fcc039b0c)

Paket `projectpapbodb.view`  digunakan untuk mengorganisasi dan menyimpan semua tampilan antarmuka pengguna (GUI) dalam proyek. Tampilan GUI ini berperan sebagai jembatan atau antarmuka antara kelas-kelas Java dalam proyek dengan database. Paket ini mencakup semua elemen visual, seperti jendela, tombol, formulir, dan komponen tampilan lainnya yang digunakan untuk berinteraksi dengan pengguna.

Tampilan GUI Aplikasi perpustakaan ini dirancang untuk memberikan akses yang mudah dan nyaman kepada pengguna untuk mengakses sumber daya perpustakaan, melakukan peminjaman buku, dan mengelola informasi pengguna. Aplikasi ini terdiri dari berbagai form dan fitur yang memberikan beragam fungsionalitas yang memudahkan pengguna dalam mengelola perpustakaan.
"FormBuku": Form ini memungkinkan pengguna untuk melakukan pencarian, melihat detail buku, dan melakukan peminjaman buku dari koleksi perpustakaan.
"FormPeminjaman": Form ini memungkinkan pengguna untuk mengajukan permohonan peminjaman buku dan mencatat detail peminjaman.
"FormPengembalian": Form ini memungkinkan pengguna untuk dapat melakukan pengembalian buku
"FormHistory": Form ini menyediakan riwayat peminjaman dan pengembalian pengguna, memungkinkan mereka untuk melacak aktivitas peminjaman sebelumnya.
"FormLogin": Form ini berfungsi sebagai autentikasi, memungkinkan pengguna untuk masuk ke aplikasi dengan akun mereka.
"FormSplash": Tampilan sambutan saat aplikasi pertama kali dibuka, memberikan pengalaman pengguna yang menarik saat memulai aplikasi

## Penjelasan Output
![Screenshot 2023-11-03 140751](https://github.com/sittii/PA-PBO/assets/127497591/aac93f52-a959-4eac-995c-ca2dacf27942)

Pada tampilan awal Perpustakaan akan menampilkan Formsplash secara bertahap dari 0 hingga 100% untuk memberikan kesan loading.

![Screenshot 2023-11-03 140804](https://github.com/sittii/PA-PBO/assets/127497591/a2edac70-f114-4588-bdfd-98639cb46f20)

Pada tampilan ini adalah tampilan login dari perpustakaan, petugas dan anggota akan dapat mengakses.

![image](https://github.com/sittii/PA-PBO/assets/123925640/e8449c11-7651-4395-8746-39b38440d79f)

Apabila petugas ingin mengakses aplikasi, maka silahkan untuk memasukkan username dan password yang telah ditentukan

![image](https://github.com/sittii/PA-PBO/assets/123925640/81ff806f-536d-47a5-993f-3fca38cfa71e)

![image](https://github.com/sittii/PA-PBO/assets/123925640/b512a750-7b13-4554-8e14-9cc7aa258152)

Tampilan saat petugas berhasil masuk kedalam aplikasi

![image](https://github.com/sittii/PA-PBO/assets/123925640/8672c75f-f357-4ba8-a12c-36eab89a94e1)

Petugas diberikan akses untuk dapat mengelola data buku, petugas dapat melakukan menambah, mengubah, menghapus data buku yang ada diperpus

![image](https://github.com/sittii/PA-PBO/assets/123925640/02aef78e-38ab-45c9-9e09-69d4e96ff6bc)

Tampilan ketika petugas berhasil menambah data buku

![image](https://github.com/sittii/PA-PBO/assets/123925640/f9ff8d8a-7341-46b4-84ab-48eb4d408e0d)

![image](https://github.com/sittii/PA-PBO/assets/123925640/583cd8fd-ccdc-48a8-93b5-9eb491221323)

Petugas juga memiliki hak akses untuk mengonfirmasi pembayaran denda yang terkait dengan peminjaman tertentu. Ketika seorang anggota datang untuk membayar denda, petugas dapat menggunakan menu ini untuk membantu anggota dalam proses pengembalian buku dan pembayaran denda

![Screenshot 2023-11-03 081636](https://github.com/sittii/PA-PBO/assets/127497591/6a1bfbb3-e302-4abc-8c46-8feaabe98d0e)

Lalu apabila anggota ingin mengakses aplikasi,  maka anggota harus melakukan pembuatan akun (registrasi) terlebih dahulu.

![Screenshot 2023-11-03 081649](https://github.com/sittii/PA-PBO/assets/127497591/402c2721-6610-456c-bf01-6c0cc00188a3)

Jika anggota telah membuat akun maka akan menampilkan Berhasil membuat akun

![Screenshot 2023-11-03 081740](https://github.com/sittii/PA-PBO/assets/127497591/00e54801-59b4-4572-bf76-d9ac73bfbb67)

Untuk masuk ke perpustakaan, anggota harus memasukan ussername dan password yang telah di buat tadi.

![Screenshot 2023-11-03 081753](https://github.com/sittii/PA-PBO/assets/127497591/46eba78a-4c57-4f4e-8d0a-2a42ab056223)

Pada tampilan ini anggota sudah masuk ke sistem perpustakaan dan bisa meminjam buku yang diinginkan.

![Screenshot 2023-11-03 081828](https://github.com/sittii/PA-PBO/assets/127497591/7d463d02-db0e-4f07-b2dd-2823920b4881)

ini adalah tampilan dari from peminjaman buku dengan menampilkan informasi buku-buku yang tersedia, anggota langsung bisa memilih buku mana yang ingin dipinjam.

![Screenshot 2023-11-03 081836](https://github.com/sittii/PA-PBO/assets/127497591/b8c8f10b-7c6d-48e4-a36d-43ea504a3d33)

Jika anggota telah melakukan peminjaman buku maka akan menampilkan peminjaman berhasil.

![Screenshot 2023-11-03 081852](https://github.com/sittii/PA-PBO/assets/127497591/46b7fe30-e301-4e45-a416-e157785ae13e)

Pada tampilan ini menunjukan history peminjaman yang telah dilakukan anggota, dalam proses peminjaman buku ini setiap peminjaman diberikan waktu selama 7 hari sebelum tanggal pengembalian ditetapkan. jika buku dikembalikan melewati batas waktu 7 hari, maka anggota tersebut akan dikenakan denda sesuai dengan kebijakan perpustakaan.

![Screenshot 2023-11-03 081909](https://github.com/sittii/PA-PBO/assets/127497591/4fd6775e-afba-4483-88dc-5029f3389fd1)

Pada tampilan ini menunjukan from pengembalian buku, jika anggota yang ingin mengembalikan buku yang telah dipinjem maka sistem akan langsung memproses pengembalian buku.

![Screenshot 2023-11-03 081947](https://github.com/sittii/PA-PBO/assets/127497591/2d4ccc8b-3d36-48e5-9fe7-32f5b47e6e93)

Jika menunjukan tampilan ini menandakan bahwa proses pengembalian buku telah berhasil.

![image](https://github.com/sittii/PA-PBO/assets/123925640/e5236d88-c4f9-4802-87ef-8dad516671ee)

![image](https://github.com/sittii/PA-PBO/assets/123925640/6bda4a27-273d-42b3-9079-e8c797cc679d)

Namun apabila terdapat kasus yang seperti ini, anggota telat melakukan pengembalian buku, maka akan muncul tampilan seperti, maka itu artinyaa anggota diharuskan datang ke perpustakaan secara offline untuk melakukan pembayaran denda secara tunai kepada petugas perpustakaan. Data anggota yang terkena denda akan secara otomatis masuk kedalam database denda, dan hanya petugas yang memiliki akses terhadap data tersebut

Apabila anggota telah melakukan pembayaran secara tunai kepada petugas perpustakaan, maka petugas akan mengkonfimasi pengembalian buku anggota tersebut

![image](https://github.com/sittii/PA-PBO/assets/123925640/0a0a3404-5083-45a0-8af7-546d96b10485)

![image](https://github.com/sittii/PA-PBO/assets/123925640/17881d03-ca30-458f-a656-4b3817b88814)

Tampilan history anggota saat pengembalian buku dan pembayaran dendanya  telah dikonfirmasi oleh petugas

![image](https://github.com/sittii/PA-PBO/assets/123925640/2916d6fb-cdd6-4945-94d2-0fa495dcc296)



