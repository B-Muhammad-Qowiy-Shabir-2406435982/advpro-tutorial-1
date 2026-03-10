Module 1:

Refleksi 1:

Pada pengembangan aplikasi ini, saya telah mengimplementasikan
fitur Edit dan Delete Product menggunakan Spring Boot. Struktur 
kode sudah menerapkan prinsip separation of concerns dengan
pemisahan yang jelas antara Controller, Service, dan Repository
sehingga kode lebih mudah dipahami dan dirawat.

Prinsip clean code yang diterapkan antara lain penggunaan nama
method yang deskriptif, pembagian tanggung jawab tiap layer,
serta menghindari duplikasi logika bisnis. Selain itu, alur create,
update, dan delete dipisahkan dengan jelas agar setiap fitur
memiliki tujuan yang spesifik.

Untuk secure coding, productId dibuat secara otomatis menggunakan
UUID sehingga tidak bergantung pada input pengguna dan mengurangi
risiko manipulasi data. Akses ke data juga dilakukan melalui
service layer, bukan langsung dari controller.

Kekurangan yang masih ada adalah penggunaan penyimpanan data
in-memory (List) yang belum persisten dan belum thread-safe.
Perbaikan yang dapat dilakukan ke depannya adalah menggunakan
database dan menambahkan validasi input agar data yang masuk
lebih terjamin keamanannya.

Refleksi 2:
1. Setelah menulis unit test, saya merasa lebih percaya diri 
 terhadap kode yang saya buat. Unit test membantu memastikan
 bahwa setiap bagian kecil dari program bekerja sesuai
 dengan yang diharapkan dan memudahkan saya untuk mendeteksi
 kesalahan sejak dini. Selain itu, unit test juga membuat proses
 refactoring menjadi lebih aman karena saya dapat segera
 mengetahui jika ada perubahan yang merusak fungsionalitas.

   Namun, 100% code coverage tidak menjamin bahwa kode bebas
 dari bug atau error. Code coverage hanya mengukur apakah baris
 kode dijalankan, bukan apakah logika yang diuji sudah benar
 atau semua kemungkinan kesalahan sudah tercover. Oleh karena itu,
 kualitas test (assertion yang tepat, skenario yang relevan)
 jauh lebih penting dibandingkan sekadar mengejar angka coverage
 yang tinggi.

2. Jika setelah membuat CreateProductFunctionalTest.java saya
 diminta untuk membuat functional test lain (misalnya untuk
 memverifikasi jumlah item pada product list), lalu saya
 membuat class baru dengan setup dan instance variables yang
 sama, maka hal ini berpotensi menurunkan kebersihan dan kualitas
 kode.

   Saran untuk membuat kode lebih bersih adalah dengan membuat
 asetiap class test sebaiknya hanya menguji satu fitur atau satu
 aspek fungsional tertentu agar mudah dipahami dan dirawat.

Module 2:

Refleksi:

1. Selama mengerjakan exercise, terdapat beberapa isu kualitas
kode yang ditemukan. Salah satu isu utama adalah rendahnya test
coverage, khususnya pada layer repository. Hal ini diperbaiki
dengan menambahkan unit test yang mencakup fungsi-fungsi utama
seperti pembuatan produk, pengambilan daftar produk, serta 
kondisi ketika data masih kosong. Strategi yang digunakan adalah
memprioritaskan pengujian pada logika bisnis inti agar setiap
method publik memiliki pengujian yang memadai.

Selain itu, terdapat isu terkait struktur dan konsistensi kode,
seperti bagian kode yang belum teruji sepenuhnya. Perbaikan
dilakukan dengan menambahkan pengujian yang relevan sehingga
kode tersebut benar-benar divalidasi oleh test suite. Proses
perbaikan selalu mengacu pada laporan dari tools analisis
kualitas kode dan code coverage agar hasilnya terukur dan sesuai
dengan standar kualitas.

Secara keseluruhan, strategi yang digunakan bersifat iteratif,
yaitu mengidentifikasi isu dari hasil pipeline CI, memperbaiki
isu dengan dampak terbesar terlebih dahulu, lalu menjalankan 
ulang pipeline untuk memastikan kualitas kode meningkat.

2. Menurut saya, implementasi yang dibuat sudah memenuhi definisi
Continuous Integration. Setiap kali ada perubahan kode yang di-push
atau dilakukan pull request ke branch utama, pipeline CI akan
berjalan secara otomatis untuk melakukan build, menjalankan
unit test, serta mengecek kualitas kode. Hal ini membantu
mendeteksi kesalahan sejak dini sebelum kode digabungkan ke branch
utama.

Implementasi ini juga sudah memenuhi konsep Continuous Deployment,
karena setelah seluruh proses CI berhasil dijalankan, aplikasi
akan dideploy secara otomatis ke Platform-as-a-Service (PaaS)
tanpa intervensi manual. Dengan demikian, setiap perubahan kode
yang lolos pengujian dapat langsung dirilis.

Secara keseluruhan, workflow CI/CD ini mendukung otomatisasi,
rapid feedback, dan stabilitas aplikasi, yang merupakan prinsip
utama dari Continuous Integration dan Continuous Deployment.

Module 3:

1. Pada proyek ini saya menerapkan beberapa prinsip dari SOLID Principles untuk meningkatkan kualitas kode, modularitas, dan kemudahan pemeliharaan sistem. Prinsip-prinsip yang diterapkan antara lain:

   1. Single Responsibility Principle (SRP)
      Setiap kelas memiliki satu tanggung jawab utama.
      Contohnya:

CarController hanya bertanggung jawab menangani HTTP request dan response.

CarService bertanggung jawab untuk logika bisnis terkait mobil.

CarRepository bertanggung jawab untuk pengelolaan data mobil.

Dengan pemisahan ini, setiap komponen memiliki tanggung jawab yang jelas dan tidak saling bercampur.

2. Open/Closed Principle (OCP)
   Kode dirancang agar terbuka untuk pengembangan tetapi tertutup untuk modifikasi.
   Contohnya dengan menggunakan interface seperti CarService dan CarRepository. Jika di masa depan ingin menambahkan implementasi baru (misalnya menggunakan database), kita cukup membuat implementasi baru tanpa mengubah kode yang sudah ada.

   3. Liskov Substitution Principle (LSP)
      Implementasi dari sebuah interface harus dapat menggantikan interface tersebut tanpa merusak fungsionalitas program.
      Contohnya CarRepositoryImpl dapat digunakan sebagai pengganti CarRepository tanpa mengubah perilaku program.

   4. Interface Segregation Principle (ISP)
      Interface dibuat spesifik sesuai kebutuhan sehingga kelas tidak dipaksa mengimplementasikan metode yang tidak digunakan.
      Contohnya CarService hanya berisi method yang berhubungan dengan operasi pada objek Car.

      5. Dependency Inversion Principle (DIP)
         Komponen tingkat tinggi tidak bergantung pada implementasi konkret, melainkan pada abstraksi.
         Contohnya CarController tidak bergantung langsung pada CarServiceImpl, tetapi pada interface CarService.

2. Penerapan SOLID memberikan beberapa keuntungan dalam pengembangan proyek ini.

   1. Kode lebih mudah dipelihara (maintainable)
      Karena setiap kelas memiliki tanggung jawab yang jelas, perubahan pada satu bagian tidak mempengaruhi bagian lain.
      Contoh: jika ingin mengubah cara penyimpanan data mobil dari List ke database, kita hanya perlu mengubah implementasi CarRepository.

   2. Kode lebih mudah dikembangkan (scalable)
      Dengan menggunakan interface, kita dapat menambahkan fitur baru tanpa merusak kode yang sudah ada.
      Contoh: menambahkan CarRepositoryDatabaseImpl untuk menyimpan data di database tanpa perlu mengubah CarController.

   3. Kode lebih mudah diuji (testable)
      Dengan adanya abstraction dan dependency injection, kita dapat menggunakan mock object saat melakukan unit testing.
      Contoh: saat menguji CarService, kita bisa mengganti CarRepository dengan repository palsu (mock).

   4. Struktur kode lebih rapi dan modular
      Kode menjadi lebih terstruktur karena setiap layer memiliki fungsi masing-masing seperti controller, service, dan repository.

3. Jika SOLID tidak diterapkan, beberapa masalah dapat muncul dalam proyek.

   1. Kode sulit dipelihara
      Jika satu kelas menangani banyak tanggung jawab, perubahan kecil dapat menyebabkan banyak error.
      Contoh: jika CarController langsung mengelola data mobil tanpa service atau repository, maka semua logika akan bercampur dalam satu kelas.

   2. Kode sulit dikembangkan
      Tanpa menggunakan interface, setiap perubahan implementasi akan memaksa kita mengubah banyak bagian kode.
      Contoh: jika CarController langsung menggunakan CarServiceImpl, maka ketika implementasi service berubah, controller juga harus ikut diubah.

   3. Kode sulit diuji
      Tanpa dependency injection, unit testing menjadi sulit karena kita tidak bisa mengganti dependency dengan mock object.

   4. Kode menjadi tidak fleksibel
      Tanpa abstraksi, sistem akan sulit beradaptasi dengan kebutuhan baru di masa depan.
      Contoh: jika penyimpanan data awalnya menggunakan List dan ingin diganti menjadi database, seluruh kode mungkin harus diubah.