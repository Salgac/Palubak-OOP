# Zadanie OOP - Palubný počítač #

Táto repo slúži pre vypracovanie zadania na predmet OOP. Ide o vytvorenie simulácie palubného počítača Buse v jazyku Java.

---

## Inštrukcie pre spustenie ##

Projekt je vytváraný v jazyku Java, preto je potrebné mať nainštalovanú Javu. 

V repozitári sa nachádza iba src súbor, a je nutné skompilovať tento projekt pred jeho spustením. 
Výsledný projekt sa potom dá spustiť cez triedu **pp/main/Main.class**, spustením metódy main().

Odporúčam tiež nainštalovať font z pp/resources/pixelmixMono.ttf.

---

## Možnosti práce s programom ##
Program slúži na (zatiaľ čiastočnú) simuláciu palubného počítača BUSE BS100. Na interakciu so systémom sa používajú numerické tlačidlá na samotnom zariadení.
Systém obsahuje aj display, na ktorom sa vypisujú požadované informácie. 

Existujú dva módy, ktorými sa dá interagovať so systémom - mód voľby funkcie, a mód zadávania údajov. 
Po prvom stlačení tlačidla s funkciou, sa zobrazia aktuálne údaje zadané v systéme. Po nasledovnom stlačení numerickej klávesy sa tieto údaje začnú prepisovať. 
Tieto funkcie sa dajú rušiť a potvrdzovať žltými tlačidlami akceptácie a kvitácie.

### Odporúčaný postup re základné vyskúšanie programu ##
Základom systému (doteraz implementovaného) je prihlásiť vodiča a spustiť linku. 

***Vytvorme scenár:***
	Chceme zadať električkovú linku číslo **4**, poradie *12*. Linka dnes jazdí v prázdninovom režime (typ grafikonu číslo 4).
	Naše šesť-miestne číslo bude vyzerať nasledovne: "**004***12*4".
	Číslo vodiča má každý vodič svoje unikátne, pre naše testovanie to môže byť kludne "12345".

Zadávanie týchto údajov sa realizuje nasledovne:

1. Zatlačím tlačidlo "3 - Služba, vodič".
2. Na displayi sa objaví aktuálny stav zadanej služby.
3. Môžem zadať číslo služby pomocou numerických kláves, a potvrdím tlačidlom "Potvrdiť".
4. Display následne vypíše číslo vodiča, ktoré je tiež potrebné zadať a potvrdiť.
5. Po zadaní údajov display vypíše otázku, či je zadaná služba správna.
6. Po potvrdení sa spustí linka ktorá bola zadaná (ešte nieje naimplementované).

Zadané údaje sa po poslednom kroku zapísali do pamäte. Môžeme si všimnúť, že číslo linky ostáva vypásané na poslednom riadku displaya - za písmenom L (v našom prípade "L004").

Pomocov tlačdiel 1 a 2 možno niektoré z týchto údajov aj samostatne meniť, rovnakým postupom ako je opísaný vyššie.

### Zoznam funkčných (doteraz) naimplementovaných tlačidiel/funkcií ###

* 1 - Linka, Poradie
* 2 - Cieľ
* 3 - Služba, vodič
* tlačidlá dvojitých šípok
* tlačidlá akceptácie a kvitácie
* numerické tlačidlá

---

## Použité OOP princípy, a kde ich nájsť ##

#### Dedenie ####

Dedenie je možné nájsť v skoro každej triede. 
Konkréne je to napr. dedenie z BuseButton (ktorá dedí z JButton) pre každú triedu tlačidiel.

#### Polymorfizmus ####

V triede main/Panel sa nachádza ArrayList tlačidiel typu BuseButton, ktorý je zaplnený inštanciami tried BasicButton, NumericButton a ArrowButton.
Použitie sa dá nájsť aj pri mnohých ďalších použitých ArrayListoch.

#### Agregácia ####

Agregácia sa dá nájsť hlavne v triede main/Panel. Táto trieda obsahuje všetky elementy ktoré vykresľujú hlavné grafické okno, a tie tiež používajú agregáciu na svoje fungovanie.


#### Vypracovanie zadania obsahuje aj mnohé iné OOP princípy. ####

---

## Autor ##

* **Dominik Šalgovič**

V prípade otázok na prácu s programom ma neváhajte kontaktovať na môj email: xsalgovic@stuba.sk
