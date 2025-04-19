
# 🧾 Java Spring Boot Uygulaması: Müşteri Sipariş ve Fatura Yönetim Sistemi

Bu proje, Java ve Spring Boot kullanılarak geliştirilmiş bir **müşteri sipariş ve fatura yönetim sistemidir**. Müşteriler sisteme kaydolabilir, sipariş oluşturabilir, siparişlerine bağlı faturaları görebilir ve çeşitli filtreleme işlemleri yapabilirler. Uygulama PostgreSQL veritabanı kullanarak gerçek veri kalıcılığı sağlamaktadır.

---

## 🚀 Teknolojiler & Araçlar

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- MapStruct
- Stream API
- Lombok

---

## 🧩 Yazılım Tasarımı & Kullanılan Kavramlar

### 🔹 OOP Kavramları
- `final`, `static` alanlar
- `constructor` kullanımı
- `inheritance`, `polymorphism`, `encapsulation`
- Koleksiyonlar: `List`, `Set`, `Map`

### 🔸 SOLID Prensipleri
- **Single Responsibility:** Her sınıf tek sorumluluk taşır.
- **Open/Closed:** Genişletmeye açık, değişime kapalı yapı.
- **Liskov Substitution:** Alt sınıflar üst sınıfın yerine geçebilir.
- **Interface Segregation & Dependency Inversion:** Gerektiği yerlerde uygulanmıştır.

---

## 🗂️ Proje Yapısı

```
src/
└── main/
    └── java/
        └── com/
            └── mervesaruhan/
                ├── controller/
                ├── dao/
                ├── dto/
                ├── entity/
                ├── enums/
                ├── mapper/
                ├── service/
                └── InvoiceAppApplication.java
```

---

## 🧪 Uygulama Özellikleri

- 🔹 Müşteri oluşturulabilir ve sistemde saklanabilir
- 🔹 Her müşteriye ait dinamik siparişler ve faturalar oluşturulabilir
- 🔹 Fatura tutarları kullanıcı tarafından esnek şekilde belirlenebilir
- 🔹 Fatura tarihleri otomatik oluşturulur, ay bazlı analizler yapılabilir
- 🔹 PostgreSQL veritabanı ile kalıcı veri yönetimi sağlanır
- 🔹 Java Stream API ile gelişmiş filtreleme ve analiz fonksiyonları desteklenir

### 🔍 Sağlanan Analiz ve Listelemeler (Verilere Göre Dinamik)

1. Tüm müşterilerin listelenmesi
2. İçerisinde `"...."` harfi geçen müşterilerin filtrelenmesi
3. Belirli bir ayda kayıt olan müşterilerin fatura toplamı
4. Tüm faturaların listelenmesi
5. .... TL üstü faturaların listelenmesi
6. .... TL üstü faturaların ortalamasının alınması
7. .... TL altı faturalara sahip müşterilerin isimlerinin listelenmesi
8. Belirli bir ayın ortalaması .... TL’nin altında olan faturaların sektörlerinin listelenmesi

---

## 🛠️ Kurulum ve Çalıştırma

### PostgreSQL Ayarları
`application.properties` veya `application.yml` dosyasına PostgreSQL bilgilerinizi ekleyin:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/invoiceapp
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### Maven Komutları

```bash
# Bağımlılıkları yükle
mvn clean install

# Uygulamayı başlat
mvn spring-boot:run
```

Uygulama varsayılan olarak `http://localhost:8080` üzerinden çalışır.

---

## 📌 Örnek API Endpoint'leri

```http
GET    /api/customers                     → Tüm müşterileri listeler
POST   /api/customers                     → Yeni müşteri ekler
GET    /api/invoices                      → Tüm faturaları listeler
GET    /api/invoices/above/1500          → 1500 TL üstü faturaları getirir
GET    /api/customers/with-letter/C      → 'C' harfi içeren müşteriler
GET    /api/invoices/month/6             → Haziran faturalarının toplamı
...
```

---

## 🧑‍💻 Geliştirici

> 👩‍💻 **Merve Saruhan**  
> GitHub: [@mervesaruhan](https://github.com/mervesaruhan)  
> Proje kapsamında tüm geri bildirim ve katkılara açıktır.

---

## 📄 Lisans

Bu proje eğitim amaçlıdır. Her türlü kişisel veya akademik çalışmada kullanılabilir.
