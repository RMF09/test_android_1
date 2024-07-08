Test Android Developer  Reksa MF


PART 1 - MANDATORY 1.
Git : https://github.com/RMF09/test_android_1.git


PART 2 1. 

1. Perbedaan SharedFlow dan StateFlow
SharedFlow:
Tidak menyimpan nilai terakhir yang dipancarkan. Setiap kolektor akan mendapatkan data baru saat mulai mengumpulkan.
Digunakan untuk event-driven programming (misalnya event klik tombol).
StateFlow:
Menyimpan dan memancarkan nilai terakhir yang diterima kepada setiap kolektor baru. Kolektor baru akan langsung menerima nilai terbaru saat mulai mengumpulkan.
Digunakan untuk menyimpan dan mengamati state aplikasi.
2. Jenis Scoped Function dalam Kotlin
let:
Menjalankan blok kode dengan objek sebagai receiver (disebut sebagai it).
Digunakan untuk menghindari null pointer exception atau chaining multiple calls.
run:
Menjalankan blok kode dengan receiver sebagai this.
Mengembalikan hasil dari blok kode terakhir.
Cocok digunakan untuk inisialisasi objek atau pemanggilan fungsi dari konteks tertentu.
with:
Serupa dengan run tetapi digunakan untuk objek non-null sebagai receiver.
Tidak mentransformasi objek yang digunakan.
apply:
Menjalankan blok kode dengan receiver sebagai this.
Mengembalikan receiver setelah eksekusi blok kode.
Digunakan untuk inisialisasi objek.
also:
Menjalankan blok kode dengan receiver sebagai it.
Mengembalikan receiver setelah eksekusi blok kode.
Digunakan untuk side effects atau tindakan tambahan pada objek.

3. 
Unit Test:
Menguji bagian terkecil dari aplikasi (biasanya fungsi atau metode).
Dilakukan pada local JVM tanpa kebutuhan perangkat atau emulator.
Cepat dan digunakan untuk pengujian logika aplikasi.
Instrument Test:
Menguji aplikasi dalam lingkungan perangkat atau emulator Android.
Menguji interaksi antara komponen UI dan sistem.
Lebih lambat dibandingkan unit test karena memerlukan perangkat fisik atau virtual.

4. View Binding adalah fitur yang mempermudah pengikatan antara layout XML dan kode Kotlin atau Java. Dengan View Binding, Anda dapat menghindari penggunaan findViewById dan mendapatkan tipe yang aman dari ID view.

5. c. Application Not Responding
6. c. AndroidManifest.xml


7. Git : https://github.com/RMF09/Test-Android-MVVM.git
