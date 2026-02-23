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