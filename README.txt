------Program Temel Algoritmasý------
 ->Program kullanýcýdan okunacak dosya ismini ister
 ->Dosyayý kod ve sýnýf yapýsý ile okur çözümler
 ->Çýktýlarý kullanýcýnýn belirttiði text dosyasý içine yazar

------Program Sýnýf Yapýsý Ve Ýliþkileri------
 ->App.java
	Programýn yürütüldüðü main class týr
	Dosya okumasý sýrasýnda Enemy, Hero ve EnemyOnthePath sýnýflarýndan türetilen nesnelerin get ve set metodlarýný kullanarak onlarý initialize eder ve özelliklerine deðer verir.
	
	detecetEnemy Fonx -> text dosyasýnda belirtilen düþman türlerini belirler ve bu türden bir arrayList ile onlarý saklar
	setEnemyHp Fonx ->   arrayList de saklanan düþman türlerinin HealtPoint özelliðine deðer verir.
	setEnemyAttackPoint Fonx -> arrayList de saklanan düþman türlerinin attackPoint özelliðine deðer verir.
	detectEnemiesOnThePath Fonx -> Hero ve Resource arasýndaki yol üzerinde bulunan düþman varlýklarý EnemyOnThePath sýnýfýndan nesneler türeterek arraylist içinde saklar ve onlara Enemy sýnýfýndan özellikler ekler. 
		Ve ayrýca bu düþman varlýklarý yakýnlýk parametresine göre yakýndan uzaða sýralar. Böylece fight Fonx yürütülmesi sýrasýnda kolaylýk saðlar.
	fight Fonx-> Hero sýnýfýndan türetilen nesnesnin yol üzerinde sýrasýyla en yakýndan baþlayarak düþman varlýklar ile mücadele çözümlemesini yapar, sonunçlarý hem konsola hemde kullanýcýnýn belirteceði text dosyasýný yazar.

 ->Hero.java 
	Bu sýnýftan hero nesneleri türetilir.
	defalult ve custom olmak üzere iki kurucu içerir. Bir initailize etmek biride App sýnýfýnýn fight fonx içinde deðerleri çaðýrmak için.
	Custom Kurucu içinde field deðerlerinin hesaplamasýný yapar.
	get ve set metodlarý ile gerekli deðerleri çekilir ya da yeniden düzenlenir.

 ->Enemy.java 
	Düþman tipinin, hp ve attackPoint deðerinin belirlendiði sýnýftýr.
	Bu sýnýftan düþman nesneleri türetilir.

->EnemyOnThePath.java
	Yol üzerindeki düþman tiplerinin ve özelliklerinin belirlendiði sýnýftýr.
	radar dan alýnan dosyadaki veri yapýsýnýn ve düþman sayýsýnýn deðiþkenliði üzerine yazýlmýþtýr ve çözümleme kýsmýnda kolaylýk saðlar.

->RadarFile.java
	Kullanýcýn belirttiði text dosyasýný alýr, okur ve satýrlara ayýrarak çözümler. Yardýmcý bir sýnýfýr.
	Girdi dosyasýnýn uzantýsýnýn deðiþiklik göstermesi olasýlýðýna karþý modifiye edilebilir bir sýnýftýr.


------Program Hangi Ortamda Yazýldý?-------
	->Program IntelliJ IDEA 2017.1 sürümlü ide üzerinde 
	->Extra bir framework, test yada build tool olmadan 
	->JAVA SDK : version "1.8.0_91" ile
	->Java dilinde yazýlmýþtýr.

------Program Nasýl Çalýþtýrýlýr ?------
	->Program java dilinin temel yetenekleri kullanýlarak yazýldýðý için diðer herhangi bir ide üzerinde çalýþtýrýlmasý büyük ihtimal ile problem yaratmayacaktýr.
	->App main class ý Run edildikten sonra consolda program sizden Proje dosyasý içinde bulunan input dosyasýnýn adýný ister. herhangi bir uzantý eklemeden(.txt vs) direk dosya ismi yazýn ve enter tuþlayýn
	->Program ikinci olarak sizden çýktý olarak yazýlacak dosyanýn ismini ister. Yine uzantý olmadan dosya ismini girin ve enter tuþlayýn.
	->Program Çözümlemeyi yaptýktan sonra sonuçlarý hem konsola hem de ismini verdiðiniz çýktý dosyasýna yazar(dosya halihazýrda bulunmasý gerekmez program yeni bir dosya oluþturur).
	->Proje dosyanýz içinde çýktý dosyasýný inceleyebilirsiniz.

-------ÖNEMLÝ------
	->Mailde ekte gönderilen girdi dosyalarýný ben okumada ve çalýþtýrmada size kolaylýk olsun diye proje dosyasýnýn içine SampleInput1.txt ve SampleInput2.txt olarak kayýt ettim. Dilerseniz ayný örnek girdileri baþka bir dosya ismi ile kayýt edip 
	o þekilde de çalýþtýrabilirsiniz.
	->SampleOutPut1 ve SampleOutPut2 dosyalarý ben çalýþtýrdýðýmda yazýlan çýktý dosyalarýdýr. Silebilir veya baþka isimde çýktý dosyalarýna yazdýrýp sonucu görebilirsiniz.
	