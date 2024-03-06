# Advanced Programming EShop
# Navigation List
- [module 1](#module-1)
- [module 2](#module-2)
- [module 3](#module-3)
- [module 4](#module-4)
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

## Module 3
- Explain what principles you apply to your project!
    - S (Single Responsibility Principle)
        - Pertama, pada bagian `ProductController` awalnya saya meletakkan bagian `homePage()` pada `ProductController`. Ini tidak menerapkan SRP karena `homePage` seharusnya memiliki tanggung jawab tersendiri untuk halaman home yang berbeda fungsionalitas . Oleh karena itu saya membuat class baru `HomeController`
        - Kedua, pada bagian `ProductController` terdapat class `CarController` yang extends `ProductController`.`CarController` seharusnya dipisah menjadi bagian tersendiri karena `CarController` seharusnya memiliki tanggung jawab tersendiri untuk halaman car yang berbeda fungsionalitas.

    - L (Liskov Substitution Principle)
        - Pada code saya, awalnya `CarController` merupakan subclass `ProductController`. Namun, kedua hal ini berbeda fungsi dan `CarController` tidak dapat menggantikan `ProductController`. Oleh karena itu, saya pisah menjadi dua class yang berbeda.

    - I (Interface segregation Principle)
        - Dengan memisahkan implementasi `CarService` dan `ProductService`, kita dapat memenuhi prinsip ini, yang mana setiap interface memenuhi tanggung jawab nya masing-masing sesuai klien tertentu.

    - D (Dependency Inversions Principle)
        - Pada bagian `CarController` terdapat `private CarServiceImpl carService`. Berdasarkan prinsip DIP seharusnya saya bergantung pada level sebuah interface atau fungsi abstrak dibandingkan level class atau function yang concrete. Oleh karena itu, saya ubah menjadi `private CarService carService` yang bergantung pada interface.

-  Explain the advantages of applying SOLID principles to your project with examples.
    - Dengan menerapkan prinsip SOLID code kita dapat lebih mudah di maintain. Contohnya, dengan prinsip SRP, kita tahu bahwa setiap kelas memiliki tanggung jawabnya masing-masing.
    - Code kita lebih mudah untuk diuji dan bug yang muncul dapat lebih mudah dicek karena menerapkan prinsip DIP dan SRP. Contohnya, kita dapat membuat tes unit yang fokus pada satu tanggung jawab kelas atau metode tertentu. Dalam contoh ini, kita dapat membuat tes unit khusus untuk `createProductPost` tanpa harus mempertimbangkan detail implementasi atau logika bisnis lain yang mungkin ada dalam ProductService.
    - Code kita jadi lebih mudah dibaca dan dipahami. Dengan memecah method-method menjadi beberapa bagian yang memiliki tanggung jawab sendiri, orang lain dan kita sendiri akan lebih mudah memahami saat akan membaca di kemudian hari.
    - Dengan menerapkan SOLID, code kita juga akan lebih mudah ditambah fitur baru tanpa menyebabkan adanya bug baru di bagian lainnya.

-  Explain the disadvantages of not applying SOLID principles to your project with examples.
    - Apabila tidak menerapkan prinsip solid, code kita akan lebih susah untuk dijaga karena code sangat complex dan susah dipahami. Contohnya, ketika kita tidak menerapkan SRP, maka kita akan kebingungan terkait fungsi code tersebut karena adanya hubungan dengan method lain.
    - Code kita akan lebih susah diuji karena tiap fungsionalitas tidak independen yang menyebabkan proses pencarian bug akan sulit karena banyaknya bagian yang terlibat. Contohnya, kita ingin test suatu fungsi di `CarController`. Namun dengan bergantungnya pada fungsi lain kita akan kebingungan mencari bagian mana yang menyebabkan bug.
    - Penambahan fitur baru akan lebih sulit karena ada kemungkinan kita dapat memunculkan bug baru yang disebabkan bagian lain. Hal ini tentunya akan menjadi kesulitan saat ingin menelusuri bagian yang mana kembali.

## Module 4
1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.
- Menurut saya, dengan penerapan TDD flow pengerjaan jadi lebih jelas dan cepat. Dengan membuat test terlebih dahulu, maka saat kita implementasi kita sudah benar-benar bisa memastikan dan memaintain kebenaran code kita.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.

- Menurut saya, code saya sudah mengimplementasikan F.I.R.S.T
    - Fast: Karena sudah membuat testing dengan efisien.
    - Isolated: Tes berdiri tidak bergantung pada tes yang lain.
    - Repeatable: Tes dapat diulang dengan hasil yang konsisten.
    - Self-validating: Tes memberikan hasil pass atau fail melalui asersi tanpa intervensi manual.
    - Timely: Tes dibuat sebelum implementasi kode.