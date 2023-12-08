# School-Form-App
Bu uygulama, öğrenci ve ders yönetimini sağlayan basit bir Java uygulamasıdır. IntelliJ IDEA kullanılarak geliştirilmiştir.

## Dosya Yapısı
- Forms: Kullanıcı arayüzü formları bulunur.
  - CourseForm.java: Ders formu için Swing arayüzü ve işlevleri içerir.
  - StudentForm.java: Öğrenci formu için Swing arayüzü ve işlevleri içerir.

- Models: Veri modelleri bulunur.
  - Course.java: Ders modeli, dersle ilgili özellikleri içerir.
  - Student.java: Öğrenci modeli, öğrenci bilgilerini içerir.
 
- Services: Uygulama hizmetleri bulunur.
  - FileService.java: Dosya işlemleri ve JSON verileri için hizmetler sağlar.
 
## Kullanım
- CourseForm.java: Ders ekleme ve yönetme işlevlerini içerir.
  - Ders kodu, adı, fakülte ve bölüm bilgilerini girerek yeni dersler ekleyebilirsiniz.
  - Mevcut dersleri listeleme ve düzenleme imkanı sağlar.

- StudentForm.java: Öğrenci ekleme ve yönetme işlevlerini içerir.
  - Öğrenci adı, soyadı, numarası, fakülte, bölüm ve ders bilgilerini girerek yeni öğrenciler ekleyebilirsiniz.
  - Mevcut öğrencileri listeleme ve düzenleme imkanı sağlar.
 
## JSON Dosyaları
- Course.json: Derslerin JSON formatında saklandığı dosya.
- Student.json: Öğrencilerin JSON formatında saklandığı dosya.

## Servisler
- FileService: Dosya oluşturma, yazma ve okuma işlemleri için metotları içerir.
  - JSON verilerini dosyalara yazma ve okuma işlevleri sağlar.
  - En büyük öğrenci numarasını ve ders kodunu bulma işlevleri vardır.
 
## Bağımlılıklar
- Bu uygulama Swing GUI bileşenlerini kullanır.
- JSON veri işleme işlevleri için org.json kütüphanesini kullanır.

## Kurulum
1. Proje dosyalarını bir Java IDE'ye (örneğin, IntelliJ IDEA) aktarın.
2. Projeyi açın ve gerekli bağımlılıkları yükleyin.
3. Uygulamayı çalıştırarak ders ve öğrenci yönetimini kullanmaya başlayın.

## Bağımlılıklar

- Bu projede Java ve Groovy dilleri kullanılmıştır. Ayrıca, JSON veri işleme için `json-20231013.jar` kütüphanesi kullanılmıştır.
