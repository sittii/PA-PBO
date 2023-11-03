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

Package papbodbd digunakan untuk menyimpan file koneksi database my sql, dan file utama dijalankan program


![image](https://github.com/sittii/PA-PBO/assets/123925640/30386da8-f49a-4779-8e40-a3339969a0e2)

Coding ini adalah bagian utama dari program Java yang mengembangkan aplikasi dengan antarmuka pengguna (GUI). Dalam program ini, kelas Formsplash digunakan untuk menampilkan layar pembuka splash screen, dan kelas FormLogin digunakan untuk tampilan login. Ketika program dijalankan, splash screen ditampilkan terlebih dahulu dengan efek loading yang disimulasikan, lalu setelah loading mencapai 100%, splash screen ditutup dan FormLogin ditampilkan untuk masuk ke menu utama. Ini memberikan pengguna pengalaman awal yang menarik sebelum mengakses menu utama.

![image](https://github.com/sittii/PA-PBO/assets/123925640/2860cb5c-a0ab-4074-9d0c-4a207c70b021)

![image](https://github.com/sittii/PA-PBO/assets/123925640/acff83c0-0101-48d6-aaaf-565b71bc111b)

Kode tersebut merupakan bagian dari sebuah aplikasi Java yang digunakan untuk mengelola koneksi dengan database MySQL. Kelas `ConnectionDatabase` ini memiliki metode `openConnection` yang digunakan untuk membuka koneksi ke database dengan menggunakan parameter seperti host, nama database, username, dan password yang telah ditentukan. Kemudian, terdapat metode `closeConnection` yang digunakan untuk menutup semua elemen terkait koneksi, seperti `resultSet`, `statement`, `preparedStatement`, dan `connection`. Jika terjadi kesalahan dalam koneksi database, kelas ini juga memiliki metode `displayErrors` untuk menampilkan pesan kesalahan. 

![image](https://github.com/sittii/PA-PBO/assets/123925640/ee057771-f00c-448c-a106-d0d89f2fd569)

![Screenshot 2023-11-03 070509](https://github.com/sittii/PA-PBO/assets/127497591/5ffdb73c-bffb-4aa2-a2ed-52c0a7a9755f)
Pada kode ini merupakan implementasi kelas dalam Bahasa java untuk mengakses ke database MySQL dengan menggunakan JDBC.
ConnectionDatabase, memiliki atribut yang digunakan untuk menyimpan informasi koneksi dan objek-objek untuk menjalankan pernyataan SQL. Metode openConnection digunakan untuk membuka koneksi ke database.
closeConnection digunakan untuk menutup koneksi dan sumber daya terkait. Terdapat pula metode displayErrors untuk menampilkan pesan kesalahan dalam eksekusi pernyataan SQL.
Dengan kode diatas ini bisa membuat ConnectionDatabese dengan membuka koneksi ke database.

![image](https://github.com/sittii/PA-PBO/assets/127497591/1319ee9e-122d-41a1-8f04-105eb20bd1c6)
Pada kode ini merupakan bagian dari java yang mengatur tampilan awal aplikasi dengan tampilan splash screen sebelum memunculkan layar masuk (login).Ttampilan Formsplash ditampilkan dengan persentase kemajuan dan status bar yang berubah secara bertahap dari 0 hingga 100% untuk memberikan kesan loading.

![Screenshot 2023-11-03 072341](https://github.com/sittii/PA-PBO/assets/127497591/e72093db-3d28-4b95-9268-64a2b0dd153a)
Pada class anggota ini merupakan turunan subclass dari class user, class anggota ini memiliki atribut tambahan yaitu alamat email Selain itu, terdapat metode tambah yang mengoverride metode yang sama dalam kelas User untuk menambahkan data anggota ke tabel Anggota dalam database. Dalam metode tambah, koneksi ke database dibuka, dan sebuah pernyataan SQL INSERT digunakan untuk memasukkan data anggota ke dalam tabel.

![Screenshot 2023-11-03 073247](https://github.com/sittii/PA-PBO/assets/127497591/7ff16dbc-f443-4057-9939-b87c82ec8f59)
Pada class buku, kode ini merupakan implementasi class buku ke dalam proyek java yang digunakan untuk mengelola data buku dan berinteraksi dengan database. Kelas Buku memiliki atribut seperti kodebuku, judulbuku, penulis, stok, dan kodeuser yang digunakan untuk menyimpan informasi buku. Terdapat juga metode-metode seperti tambahBuku, updateBuku, dan deleteBuku yang memungkinkan untuk menambahkan, memperbarui, atau menghapus data buku dalam tabel database. generateNextBukuCode digunakan untuk menghasilkan CRUD (Create, Read, Update, Delete) yang terhubung dengan database.

![Screenshot 2023-11-03 074013](https://github.com/sittii/PA-PBO/assets/127497591/fe0c7e27-ea39-4c51-8b67-e6ebd62aa9bb)
Pada class denda, kode ini merupakan implementasi class denda yang digunakan untuk mengelola data denda terkait pengembalian buku dalam perpustakaan. Kelas ini memiliki beberapa atribut seperti kodedenda, kodepinjam, kodebuku, kodeuser, dan kodeuseranggota yang digunakan untuk menyimpan informasi denda dan transaksi peminjaman. Metode simpanDenda digunakan untuk mencatat dan mengonfirmasi pembayaran denda.

![Screenshot 2023-11-03 074130](https://github.com/sittii/PA-PBO/assets/127497591/2af81635-4aa9-4bf5-91ad-8366a7f6dd94)
Pada class pemimnjaman buku ini implementasi peminjaman buku ke dalam proyek java yang digunakan untuk penyimpanan data peminjaman, pengurangan stok buku, dan pembaruan status peminjaman. Class ini memiliki hubungan seperti kodepinjam, tglpinjam, statuspinjam, tglkembali, kodeuser, dan kodebuku. Terdapat pula beberapa metode, seperti generateNextPinjamCode untuk menghasilkan kode peminjaman baru, simpan Peminjaman untuk menyimpan data peminjaman ke database, kurangi Stok Buku untuk mengurangi stok buku setelah peminjaman, dan simpan Pengembalian untuk mengupdate status peminjaman buku.


![Screenshot 2023-11-03 151639](https://github.com/sittii/PA-PBO/assets/127497591/0084a52f-2821-4dd4-b167-cbddd7afa553)
Pada class pengembalian buku ini implementasi pengembalian buku digunakan untuk mengelola pengembalian buku. Class ini merupakan turunan dari class "ConnectionDatabase" dan memiliki properti kodeuser, kodepinjam, dan kodebuku untuk menyimpan informasi terkait pengembalian buku. 

![Screenshot 2023-11-03 152248](https://github.com/sittii/PA-PBO/assets/127497591/0e610c94-4f36-4131-a84d-5a6ad5fda42e)
Pada class user ini implementasi digunakan dalam sebuah proyek manajemen pengguna (user) di sistem perpustakaan. Class ini mengelola informasi pengguna seperti nama, username, password, dan peran (role). Terdapat metode "generateNextUserCode" yang digunakan untuk menghasilkan kode pengguna baru, metode "tambah" untuk menyimpan data pengguna ke database, dan metode "login" untuk melakukan autentikasi pengguna berdasarkan username dan password. 


![Screenshot 2023-11-03 152525](https://github.com/sittii/PA-PBO/assets/127497591/70e889c7-38fa-49fa-ac9f-3fc7f07bc455)
pada tampilan gui Aplikasi perpustakaan ini memiliki berbagai form dan fitur yang memudahkan pengguna dalam mengelola perpustakaan. Form "Buku" memungkinkan pengguna untuk mencari, melihat, dan meminjam buku dari koleksi perpustakaan. "Denda" memungkinkan pengguna untuk melihat dan membayar denda jika ada keterlambatan pengembalian buku. "History" menyediakan riwayat peminjaman dan pengembalian pengguna. "Login" adalah form autentikasi untuk masuk ke aplikasi. "Splash" tampilan sambutan saat aplikasi pertama kali dibuka. Semua form ini bekerja bersama untuk menyediakan pengalaman yang komprehensif dalam mengelola perpustakaan.



## Penjelasan Output
![Screenshot 2023-11-03 140751](https://github.com/sittii/PA-PBO/assets/127497591/aac93f52-a959-4eac-995c-ca2dacf27942)
Pada tampilan awal Perpustakaan akan menampilkan Formsplash secara bertahap dari 0 hingga 100% untuk memberikan kesan loading.

![Screenshot 2023-11-03 140804](https://github.com/sittii/PA-PBO/assets/127497591/a2edac70-f114-4588-bdfd-98639cb46f20)
Pada tampilan ini adalah tampilan login dari perpustakaan, petugas dan anggota akan dapat mengakses.

![Screenshot 2023-11-03 081636](https://github.com/sittii/PA-PBO/assets/127497591/6a1bfbb3-e302-4abc-8c46-8feaabe98d0e)
Apabila anggota belum memiliki akun, maka anggota akan diminta untuk membuat akun (registrasi) terlebih dahulu.

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




















## Penjelasan Output
