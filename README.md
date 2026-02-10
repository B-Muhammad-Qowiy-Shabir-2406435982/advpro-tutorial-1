

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
