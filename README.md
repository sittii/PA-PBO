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
Pada class buku, kode ini merupakan implementasi class buku ke dalam proyek java ang digunakan untuk mengelola data buku dan berinteraksi dengan database. Kelas Buku memiliki atribut seperti kodebuku, judulbuku, penulis, stok, dan kodeuser yang digunakan untuk menyimpan informasi buku. Terdapat juga metode-metode seperti tambahBuku, updateBuku, dan deleteBuku yang memungkinkan untuk menambahkan, memperbarui, atau menghapus data buku dalam tabel database. generateNextBukuCode digunakan untuk menghasilkan CRUD (Create, Read, Update, Delete) yang terhubung dengan database.

![Screenshot 2023-11-03 074013](https://github.com/sittii/PA-PBO/assets/127497591/fe0c7e27-ea39-4c51-8b67-e6ebd62aa9bb)
Pada class denda, kode ini merupakan implementasi class denda yang digunakan untuk mengelola data denda terkait pengembalian buku dalam perpustakaan. Kelas ini memiliki beberapa atribut seperti kodedenda, kodepinjam, kodebuku, kodeuser, dan kodeuseranggota yang digunakan untuk menyimpan informasi denda dan transaksi peminjaman. Metode simpanDenda digunakan untuk mencatat dan mengonfirmasi pembayaran denda.

![Screenshot 2023-11-03 074130](https://github.com/sittii/PA-PBO/assets/127497591/2af81635-4aa9-4bf5-91ad-8366a7f6dd94)









## Penjelasan Output
