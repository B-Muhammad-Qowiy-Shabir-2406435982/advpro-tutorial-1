
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