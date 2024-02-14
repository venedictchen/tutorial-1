# Advanced Programming EShop

https://tutorial-1-eshop-venedictchen.koyeb.app

# Navigation List
- [module 1](#module-1)
- [module 2](#module-2)
# Reflection :relieved:

## Module 1

### Reflection 1.1

- Pada module pekan ini, saya mendapatkan pelajaran untuk dapat mengimplementasikan clean code. Pada awalnya, saya mengira clean code hanya memperhatikan kerapian code dengan indentasi dan rapi.

- Setelah saya mempelajari modul ini, saya mendapatkan pelajaran bahwa clean code dimulai dari penamaan, setiap function harus memiliki tugasnya masing-masing dan jelas, comment menjelaskan secukupnya, objects dan structure, dan error handling. Saya juga mempelajari cara melakukan branching untuk git flow, saya menggunakan branching jenis feature branch workflow.

- Hal yang bisa dikembangkan dari code saya adalah bagian error handling, autentikasi, serta autorisasi. Menurut saya, untuk code saya masih belum mencakup error handling sepenuhnya. Untuk akses pengguna juga masih belum diimplementasikan, baik secara autentikasi maupun autorisasi.

- Untuk kedepannya error dapat di handle dengan memberikan informasi kepada pengguna apa yang terjadi pada setiap fitur yang dijalankan. Lalu, dapat diimplementasikan autentikasi login untuk pengguna sehingga setiap orang memiliki list productnya sendiri. Untuk bagian delete dan edit dapat ditambah autorisasi sehingga hanya pengguna yang memiliki akses yang dapat melakukan action tersebut.

### Reflection 1.2

- Setelah menulis unit Test, saya merasa lebih yakin dengan code saya. Lalu, saya juga ada mengubah beberapa bagian dari code saya selama testing untuk dapat memenuhi testing yang diinginkan sehingga kode saya juga lebih improve. Testing membuat saya mendapatkan bagian-bagian yang terlewatkan oleh saya.

- Menurut saya, tidak ada batasan dalam menulis sebuah unit test dalam suatu class. Unit test juga tidak menjamin sepenuhnya code kita bebas dari bug atau error. Menurut (Sten Pittet, Attlasian) secara umum code coverage 80% adalah persentase yang baik untuk dicapai.

- Akan tetapi, code coverage yang tinggi atau bahkan 100% juga tidak menjamin aplikasi kita bebas dari error atau bug. Hal ini dikarenakan mungkin ada bagian kecil yang terlewat saat testing, terutama dari sudut pandang pengguna. Contohnya, ketika kita memiliki aplikasi yang dapat menghitung apakah suatu angka kelipatan 10. Bisa saja coverage kita 100%, akan tetapi kita belum handle kasus input alphabet. Hal-hal seperti ini yang perlu diperhatikan juga, tidak hanya persentase coverage.

- Menurut saya, apabila menambahkan file baru untuk testing jumlah item di dalam product list dengan setup dan instance variabel yang sama, dapat mengurangi cleanliness code kita.

- Kita hanya mengulang hal yang sama dan sebenarnya dapat digabung dalam satu file, tetapi berbeda fungsi. Apabila  Ini dilakukan juga sekaligus dapat meningkatkan clean code dengan fungsi yang memiliki tugasnya masing-masing.

- Jadi, menurut saya untuk kasus tersebut, menambah file baru hanya mengurangi cleannya code kita karena pengulangan hal yang tidak signifikan.


## Module 2

-  Ketika saya mengerjakan tugas ini, saya mendapatkan code quality issue, seperti penamaan nama file html yang salah. Contoh di controller createProduct, sedangkan nama file saya CreateProduct. Solusinya, saya sesuaikan yang di controller dengan HTML.

- Lalu, saya juga menambahkan beberapa test untuk coverage 100% saat `./gradlew test`, terutama di bagian service dan controller karena modul sebelumnya belum mengcover bagian itu. Saya juga ada menambahkan `<caption>` untuk table karena menjadi bug issue di sonarcloud ketika analyze.

- Menurut saya implementasi CI/CD workflow saya sudah mengikuti definisi Continuous Integration and Continuous Deployment. Code saya akan melalui proses yang berkelanjutan sesuai definisi CI/CD. Kode ini akan secara otomatis secara Continuous Integration menggunakan Github Actions. Kode akan dilakukan pengecekan dan analisis secara otomotasi menggunakan Scorecard dan Sonarcloud. Untuk Continuous Deployment sendiri saya sudah menggunakan koyeb sebagai PaaS untuk CD nya. Jadi untuk setiap perubahan akan dilakukan proses ini. Oleh karena itu, saya merasa kode saya sudah menerapkan implementasi CI/CD workflow.