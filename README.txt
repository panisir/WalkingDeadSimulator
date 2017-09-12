------Program Temel Algoritmas�------
 ->Program kullan�c�dan okunacak dosya ismini ister
 ->Dosyay� kod ve s�n�f yap�s� ile okur ��z�mler
 ->��kt�lar� kullan�c�n�n belirtti�i text dosyas� i�ine yazar

------Program S�n�f Yap�s� Ve �li�kileri------
 ->App.java
	Program�n y�r�t�ld��� main class t�r
	Dosya okumas� s�ras�nda Enemy, Hero ve EnemyOnthePath s�n�flar�ndan t�retilen nesnelerin get ve set metodlar�n� kullanarak onlar� initialize eder ve �zelliklerine de�er verir.
	
	detecetEnemy Fonx -> text dosyas�nda belirtilen d��man t�rlerini belirler ve bu t�rden bir arrayList ile onlar� saklar
	setEnemyHp Fonx ->   arrayList de saklanan d��man t�rlerinin HealtPoint �zelli�ine de�er verir.
	setEnemyAttackPoint Fonx -> arrayList de saklanan d��man t�rlerinin attackPoint �zelli�ine de�er verir.
	detectEnemiesOnThePath Fonx -> Hero ve Resource aras�ndaki yol �zerinde bulunan d��man varl�klar� EnemyOnThePath s�n�f�ndan nesneler t�reterek arraylist i�inde saklar ve onlara Enemy s�n�f�ndan �zellikler ekler. 
		Ve ayr�ca bu d��man varl�klar� yak�nl�k parametresine g�re yak�ndan uza�a s�ralar. B�ylece fight Fonx y�r�t�lmesi s�ras�nda kolayl�k sa�lar.
	fight Fonx-> Hero s�n�f�ndan t�retilen nesnesnin yol �zerinde s�ras�yla en yak�ndan ba�layarak d��man varl�klar ile m�cadele ��z�mlemesini yapar, sonun�lar� hem konsola hemde kullan�c�n�n belirtece�i text dosyas�n� yazar.

 ->Hero.java 
	Bu s�n�ftan hero nesneleri t�retilir.
	defalult ve custom olmak �zere iki kurucu i�erir. Bir initailize etmek biride App s�n�f�n�n fight fonx i�inde de�erleri �a��rmak i�in.
	Custom Kurucu i�inde field de�erlerinin hesaplamas�n� yapar.
	get ve set metodlar� ile gerekli de�erleri �ekilir ya da yeniden d�zenlenir.

 ->Enemy.java 
	D��man tipinin, hp ve attackPoint de�erinin belirlendi�i s�n�ft�r.
	Bu s�n�ftan d��man nesneleri t�retilir.

->EnemyOnThePath.java
	Yol �zerindeki d��man tiplerinin ve �zelliklerinin belirlendi�i s�n�ft�r.
	radar dan al�nan dosyadaki veri yap�s�n�n ve d��man say�s�n�n de�i�kenli�i �zerine yaz�lm��t�r ve ��z�mleme k�sm�nda kolayl�k sa�lar.

->RadarFile.java
	Kullan�c�n belirtti�i text dosyas�n� al�r, okur ve sat�rlara ay�rarak ��z�mler. Yard�mc� bir s�n�f�r.
	Girdi dosyas�n�n uzant�s�n�n de�i�iklik g�stermesi olas�l���na kar�� modifiye edilebilir bir s�n�ft�r.


------Program Hangi Ortamda Yaz�ld�?-------
	->Program IntelliJ IDEA 2017.1 s�r�ml� ide �zerinde 
	->Extra bir framework, test yada build tool olmadan 
	->JAVA SDK : version "1.8.0_91" ile
	->Java dilinde yaz�lm��t�r.

------Program Nas�l �al��t�r�l�r ?------
	->Program java dilinin temel yetenekleri kullan�larak yaz�ld��� i�in di�er herhangi bir ide �zerinde �al��t�r�lmas� b�y�k ihtimal ile problem yaratmayacakt�r.
	->App main class � Run edildikten sonra consolda program sizden Proje dosyas� i�inde bulunan input dosyas�n�n ad�n� ister. herhangi bir uzant� eklemeden(.txt vs) direk dosya ismi yaz�n ve enter tu�lay�n
	->Program ikinci olarak sizden ��kt� olarak yaz�lacak dosyan�n ismini ister. Yine uzant� olmadan dosya ismini girin ve enter tu�lay�n.
	->Program ��z�mlemeyi yapt�ktan sonra sonu�lar� hem konsola hem de ismini verdi�iniz ��kt� dosyas�na yazar(dosya halihaz�rda bulunmas� gerekmez program yeni bir dosya olu�turur).
	->Proje dosyan�z i�inde ��kt� dosyas�n� inceleyebilirsiniz.

-------�NEML�------
	->Mailde ekte g�nderilen girdi dosyalar�n� ben okumada ve �al��t�rmada size kolayl�k olsun diye proje dosyas�n�n i�ine SampleInput1.txt ve SampleInput2.txt olarak kay�t ettim. Dilerseniz ayn� �rnek girdileri ba�ka bir dosya ismi ile kay�t edip 
	o �ekilde de �al��t�rabilirsiniz.
	->SampleOutPut1 ve SampleOutPut2 dosyalar� ben �al��t�rd���mda yaz�lan ��kt� dosyalar�d�r. Silebilir veya ba�ka isimde ��kt� dosyalar�na yazd�r�p sonucu g�rebilirsiniz.
	