package org.example;

import java.util.*;

public class DnDFinal {

    static class Stav {

        //vztahy
        boolean duvera = false;
        boolean kultVi = false;
        //stavy
        boolean opatrnost = false;
        boolean znasSymbol = false;
        boolean otreseny = false;
        boolean zpozdeni = false;
        //věci
        boolean lektvar = false;
        //ovlivňuje boj
        boolean spojenec = false;
        boolean slabina = false;
        boolean prokleti = false;
        boolean ochrana = false;
        boolean tajnyVstup = false;
        boolean fraze = false;
        boolean zraneny = false;
        boolean rychle = false;
        boolean priprava = false;
        //opakování míst ve vesnici
        boolean starostaNavstiven = false;
        boolean lovecNavstiven = false;
        boolean dumNavstiven = false;
        boolean opustitVesnici = false;
        boolean pokusilSeOdejit = false;
        boolean prvniNavstevaVesnice = false;
        //místa
        boolean navstivenLes = false;
        boolean navstivenJeskyne = false;
    }

    static Scanner sc = new Scanner(System.in);
    static Stav s = new Stav();

    public static void main() {
        start();
        vesnice();
        if (!s.navstivenLes) les();
        if (!s.navstivenJeskyne) jeskyne();
        finale();
    }

    static void start() {
        System.out.println("""
            === HRA - ZASTAV KULT ===
            
            Ve hře se budeš rozhodovat, kam půjdeš a jak budeš reagovat na různé situace.
            Každá tvoje volba ovlivní další průběh příběhu i jeho konec.
            (Navíc tě může posilnit nebo oslabit.)
            Dávej pozor, protože rozhodnutí se nedají vzít zpět.
            """);
        ramecek("""
            1 - Začít hru
            2 - Konec
            """);

        int c = volba(2);
        if (c == 2) {
            System.out.println("Ukončuji hru...");
            System.exit(0);
        }

        if (!s.prvniNavstevaVesnice) {
            System.out.println("""
                
                = VESNICE HVOZD =
                Stojíš na rozcestí mezi domy.
                Z dálky slyšíš jen skučení větru a štěkot psa.
                """);
            s.prvniNavstevaVesnice = true;
        }

        System.out.println("""
            Do vesnice Hvozd přicházíš za soumraku.
            
            Vzduch je těžký, jako před bouří.
            Lidé sklopí oči, když kolem nich projdeš.
            Nikdo se neusmívá.
            
            V lese mizí lidé.
            A tady se o tom nemluví.
            """);

    }

    //začátek ve vesnici
    static void vesnice() {

        while(!s.opustitVesnici) {



            ramecek("""
                Kam půjdeš?
                
                1 - Za starostou
                2 - Za lovcem
                3 - Do opuštěného domu
                4 - Do lesa
                """);

            int v = volba(4);

            if (v == 1) starosta();
            if (v == 2) lovec();
            if (v == 3) dum();
            if (v == 4) odejit();

        }
    }


    static void starosta() {

        if (s.starostaNavstiven) {
            System.out.println("""
                
                STAROSTA...
                
                Se starostou už jsi mluvil. Nemá nic nového.
                """);
            return;
        }

        s.starostaNavstiven = true;

        System.out.println("""
            
            STAROSTA...
            
            Muž je unavený, jeho ruce se třesou.
            "Lidé mizí v lese. Ale mluvit o tom je nebezpečné."
            """);
        ramecek("""
            1 - Zeptat se diskrétně na víc informací
            2 - Tlačit na starostu
            """);


        int c = volba(2);

        if (c == 1) {
            System.out.println("""
                    
                    ZEPTAÁŠ SE DISKRÉTNĚ NA VÍCE INFORMACÍ...
                    
                    Rozhlédne se kolem, jako by se bál, že ho někdo slyší. Nakloní se k tobě blíž.
                    
                    "Ne všichni, kdo zmizeli… jsou skutečně ztracení.
                    Les si vybírá. Možná si myslíš, že je to zlé. Ale ty tomu nerozumíš. To není… náhoda.
                    
                    Když uslyšíš zpěv, neposlouchej ho dlouho.
                    Nebo… možná poslouchej. Záleží, co hledáš.

                    Některé dveře se otevírají jen těm, kdo vědí, jak zaklepat."
                    """);
            s.duvera = true;
        } else {
            System.out.println("""
                
                TLAČÍŠ NA STAROSTU...
                
                Starosta ztichne. Nevěří ti a nic dalšího ti neřekne.
                """);
            s.kultVi = true;
        }
        oddelit();
    }

    static void lovec() {

        if (s.lovecNavstiven) {
            System.out.println("""
                
                LOVEC...
                
                Lovec už ti řekl vše, co ví.
                """);
            return;
        }

        s.lovecNavstiven = true;

        System.out.println("""
            
            LOVEC...
            
            Sedí u ohně a brousí nůž.
            "Les není mrtvý."
            """);
        ramecek("""
            1 - Poslouchat lovce dál
            2 - Ignorovat ho
            """);

        int c = volba(2);

        if (c == 1) {
            System.out.println("""
            
            POSLOUCHÁŠ LOVCE DÁL...
            
            Zapamatuješ si jeho varování, aby sis dával pozor na nástrahy lesa.
            Navíc od lovce dostaneš jako dar kouzelný lektvar, který zahojí všechny rány.
            """);
            s.opatrnost = true;
            s.lektvar = true;
        } else {
            System.out.println("""
                
                IGNORUJEŠ HO...
                
                Lovec odvrátí pohled.
                """);
        }
        oddelit();
    }

    static void dum() {

        if (s.dumNavstiven) {
            System.out.println("""
            
            OPUŠTĚNÝ DŮM...
            
            Dům je stále prázdný. Nic nového už nenajdeš.
            """);
            return;
        }

        s.dumNavstiven = true;

        System.out.println("""
            
            OPUŠTĚNÝ DŮM...
            
            Dveře vržou, když je otevíráš.
            Uvnitř je prach a pach starého dřeva.
            """);
        ramecek("""
            1 - Rychle ho projdeš
            2 - Prohledáš ho
            """);


        int c = volba(2);

        if (c == 2) {
            System.out.println("""
                
                PROHLEDÁŠ HO...
                
                Nacházíš vyrytý symbol, který nepatří žádné známé víře.
                Co by asi mohl znamenat? Třeba na něj po cestě ještě narazíš...
                """);
            s.znasSymbol = true;
        } else {
            System.out.println("""
                
                RYCHLE HO PROJDEŠ...
                
                Něco se pohne ve tmě. Vyděsíš se a odcházíš rychle pryč.
                """);
            s.otreseny = true;
        }
        oddelit();
    }

    static void odejit() {

        if (s.pokusilSeOdejit || s.starostaNavstiven || s.lovecNavstiven || s.dumNavstiven) {
            s.opustitVesnici = true;
        }
        else {
            System.out.println("""
            
            CESTA DO LESA...
            
            Stojíš na okraji vesnice.
            Před tebou je les.
            Ticho je příliš tíživé.
            
            Máš zvláštní pocit, že jakmile jednou vstoupíš,
            nemusíš se už nikdy vrátit.
            
            Možná bys měl ještě něco ve vesnici zjistit.
            """);
            ramecek("""
            1 - Odejít do lesa
            2 - Ještě zůstat ve vesnici
            """);

            int c = volba(2);

            if (c == 1) {
                s.opustitVesnici = true;

                System.out.println("""
            
            ODEJÍT DO LESA...
            
            Otočíš se k lesu.
            
            Vesnice za tebou zůstává tichá.
            Nikdo tě nezastavuje.
            
            Ale něco ti dochází:
            některé odpovědi už teď nezískáš.
            """);
            }

            if (c == 2) {
                System.out.println("""
            
            ZŮSTÁVÁŠ VE VESNICI...
            
            Možná je tam ještě něco, co jsi přehlédl.
            Možná někdo, kdo ti ještě něco řekne.
            """);
            }
            oddelit();
            s.pokusilSeOdejit = true;}
    }

    //přesun do lesa
    static void les() {

        s.navstivenLes = true;

        System.out.println("""
                
                LES...
                
                Stromy jsou husté. Světlo téměř neproniká.
                Máš pocit, že tě někdo sleduje.
                """);
        ramecek("""
                1 - Jít po cestě
                2 - Jít mimo cestu
                3 - Sledovat zvuky
                """);

        int c = volba(3);

        switch (c) {
            case 1 -> cesta();
            case 2 -> mimoCestu();
            case 3 -> zvuky();
        }
    }

    static void zvuky(){
        System.out.println("""
                
                SLEDUJEŠ ZVUKY...
                
                Zvuky tě vedou hlouběji do lesa.
                Nakonec nacházíš vchod do jeskyně.
                """);

        s.rychle = true;
    }
    static void cesta() {
        System.out.println("""
            
            JDEŠ PO CESTĚ...
            
            Na cestě leží zraněný muž.
            Jeho ruce jsou od krve.
            "Nechoď hlouběji..."
            """);
        ramecek("""
            1 - Pomoci
            2 - Ignorovat
            """);

        int c = volba(2);

        if (c == 1) {
            if (s.lektvar) {
                System.out.println("""
                        
                        POMŮŽEŠ MU...
                        
                        Díky lektvaru od lovce jsi zachránil zraněného muže.
                        Ten je ti velmi vděčný a slibuje ti, že až to budeš nejvíce potřebovat, přijde ti na pomoc.
                        Ještě než odejde, řekne ti:
                        
                        "Poslouchej mě.
                        Oni tě nemůžou vzít silou.
                        Musíš jim to dovolit.
                        Ten zpěv… ta slova… to není jen rituál.
                        To je pozvání.
                        
                        Neodpovídej jim… a zůstaň svůj.“
                        """);
                s.spojenec = true;
                s.lektvar = false;
            } else {
                System.out.println("""
                        
                        SNAŽÍŠ SE MUŽI POMOCI...
                        
                        Muž už je příliš slabý na to, abys mu mohl pomoci, ale stejně oceňuje tvoji snahu.
                        Ještě než zemře, řekne ti:
                        
                        "Poslouchej mě.
                        Oni tě nemůžou vzít silou.
                        Musíš jim to dovolit.
                        Ten zpěv… ta slova… to není jen rituál.
                        To je pozvání.
                        
                        Neodpovídej jim… a zůstaň svůj.“
                     
                        """);
            }
            s.slabina = true;
        } else {
            System.out.println("""
                
                IGNORUJEŠ HO...
                
                Jeho pohled tě pronásleduje, i když odcházíš. V duchu tě proklíná.
                """);
            s.prokleti = true;
        }

        oddelit();

        //minulost
        if (s.opatrnost) {
            System.out.println("POZOR!");
            System.out.println("Díky radě lovce jsi opatrný, všímáš si včas pasti a vyhneš se jí.");
        } else {
            System.out.println("Nedáváš pozor na cestu a náhle se spustí past. Ta tě zraní.");
            s.zraneny = true;
            s.otreseny = true;
        }
    }

    static void mimoCestu() {
        System.out.println("""
                    
                    JDEŠ MIMO CESTU...
                    
                    Mezi kořeny stromů stojí kamenný oltář, na kterém jsou vyryty podivné znaky.
                    Je starý. Velmi starý.
                    """);

        if (!s.znasSymbol) {
            System.out.println("Nechápeš ale, proč tu je.");
        }
        if (s.znasSymbol) {
            System.out.println("Vzpomeneš si na symbol, který jsi našel v domě a hned ti dojde, že oltář patří kultu.");
        }

        ramecek("""
            1 - Zničíš ho
            2 - Prozkoumáš ho
            3 - Ignoruješ ho""");

        int c = volba(3);

        if (c == 1) {
            System.out.println("""
                
                ZNIČÍŠ HO...
                
                Když ho rozbiješ, les na chvíli ztichne.
                """);
            s.ochrana = true;
        } else if (c == 2) {
            System.out.println("""
                
                PROZKOUMÁŠ HO...
                
                Učíš se slova, neznámého jazyka.
                """);
            s.tajnyVstup = true;
            s.fraze = true;
        } else if (c == 3) {
            System.out.println("""
                
                IGNORUJEŠ HO...
                
                Odejdeš, ale máš pocit, že jsi udělal chybu.
                """);
        }

        System.out.println("""
                Jelikož jsi šel mimo cestu, ztrácíš orientaci v lese.
                Po dlouhém hledání jsi našel jeskyni.
                """);
        s.zpozdeni = true;

    }

    //přesun do jeskyně
    static void jeskyne() {
        oddelit();
        System.out.println("""
                
                JESKYNĚ...
                
                Tma je neproniknutelná.
                Slyšíš zpěv připomínající nářek.
                """);

        ramecek("""
                Co uděláš?
                
                1 - Vstoupit hned
                2 - Ještě se rozhlédnout kolem vstupu
                """);
        int c = volba(2);

        if (c == 2) {
            System.out.println("""
            
            ROZHLÉDNEŠ SE KOLEM...
            
            Na zemi nacházíš stopy a staré symboly vyryté do kamene.
            Cítíš, že místo je nebezpečnější, než vypadá.
            
            Jsi o něco opatrnější při vstupu.
            """);
            s.priprava = true;
        }

        if (s.tajnyVstup) {
            ramecek("""
                1 - Použít tajný vstup
                2 - Použít hlavní vstup""");

            int d = volba(2);

            if (d == 1) {
                System.out.println("""
                    
                    POUŽIJEŠ TAJNÝ VSTUP...
                    
                    Plížíš se hluboko do jeskyně bez povšimnutí.
                    """);
                return;
            }
        }

        if (s.kultVi) {
            System.out.println("""
                
                VCHÁZÍŠ HLAVNÍM VSTUPEM DO JESKYNĚ...
                
                Starosta si všiml, že jsi nebezpečný a varoval kult. Stráže tě okamžitě zpozorují. Čekají tě.
                """);
        } else {
            System.out.println("""
                
                VCHÁZÍŠ HLAVNÍM VSTUPEM DO JESKYNĚ...
                
                Vstupuješ bez povšimnutí.
                """);
        }

        //zajatci
        if (s.duvera) {
            System.out.println("""
                Jeden ze zajatců se k tobě nakloní.

                „Starosta o tobě mluvil. Čekal, že přijdeš…
                Viděl jsem ho. V plášti. Se všemi ostatními.“
                """);
        } else {
            System.out.println("Zajatci se bojí na tebe i podívat.");
        }
    }

    //konec
    static void finale() {
        oddelit();
        System.out.println("""
            
            HLUBINY...
            
            Stojí tam.
            Postava v černém plášti.
            
            "Přišel jsi pozdě... nebo přesně včas."
            """);
        ramecek("""
            1 - Mluvit
            2 - Infiltrovat
            3 - Boj
            """);

        int c = volba(3);

        if (c == 1) mluvit();
        else if (c == 2) infiltrace();
        else boj();

        konec();
    }



    static void mluvit() {
        if (s.prokleti) {
            System.out.println("Selžeš. Ovládne tě. Jeho slova tě zlomí. Padáš do tmy.");
            oddelit();
            end("TEMNÝ KONEC");
            System.out.println("""
                    Jakmile se přiblížíš,
                    ucítíš, že něco není v pořádku.
                    
                    Dojde ti proč.
                    
                    Když jsi nechal zraněného muže zemřít,
                    proklel tě.
                    
                    A právě tohle prokletí tě teď oslabuje.
                    
                    Zpěvu nedokážeš odolat.
                    
                    Ztratíš kontrolu nad sebou
                    a kult tě ovládne.
                    
                    Dopadneš přesně tak,
                    jak tě ten muž varoval.
                    """);
        }

        if (s.otreseny) {
            System.out.println("""
                Něco v tobě se pořád neuklidnilo.
                Máš pocit, že tě někdo sleduje — i teď.
                A že ten boj už možná dávno začal… jen sis toho nevšiml.
                """);        }

        if (s.slabina) {
            System.out.println("""
                Zpěv sílí.

                Snaží se dostat do tvé mysli.
    
                Ale ty si vzpomeneš na slova zraněného.
    
                Nereaguješ.
    
                Něco se zlomí.
                Jeho síla slábne.
                """);
        }
        if (s.fraze) {
            System.out.println("Oklameš ho. Mluvíš jazykem, kterému rozumí jen oni.");
        }
    }

    static void infiltrace() {

        System.out.println("""
                
                SNAŽÍŠ SE INFILTROVAT...
                """);
        if (s.kultVi) {
            System.out.println("""
            
            Starosta si všiml, že jsi nebezpečný a varoval kult. Poznali tě.
            
            Kult už ví, kdo jsi.
            Není cesty dovnitř ani zpět.
            """);
            oddelit();
            end("SELHÁNÍ");
            System.out.println("""
                    Snažíš se splynout s kultem,
                    ale uděláš chybu.
                    
                    Všimnou si tě.
                    
                    Nemáš kam utéct.
                    
                    Jsi obklopený
                    a bez šance cokoliv změnit.
                    
                    Tvoje mise končí dřív,
                    než vůbec začala.
                    """);
            return;
        }

        if (s.fraze || s.znasSymbol) {
            System.out.println("""
                Díky znalostem kultu si tě nikdo nevšímá. Procházíš mezi nimi a úspěšně se infiltruješ.
                """);
        } else {
            System.out.println("Selhal jsi, infiltrovat se ti nepodařilo.");
            oddelit();
            end("ŠPATNÝ KONEC");
            System.out.println("""
                    Neodoláš zpěvu.
                
                    Nejdřív ho jen posloucháš,
                    ale postupně mu začneš věřit.

                    Než si to uvědomíš,
                    uděláš přesně to, co chce.

                    Ztratíš kontrolu nad sebou.

                    Kult tě přijme mezi sebe —
                    ne jako rovnocenného člena,
                    ale jako další nástroj.

                    Lidé ve vesnici budou dál mizet.

                    I proto, že jsi nepomohl.
                    """);
        }
    }

    static void boj() {
        System.out.println("""
                
                ROZHODL SES BOJOVAT
                
                """);
        if (s.zpozdeni) {
            System.out.println("""
                Kvůli bloudění v lese jsi přišel pozdě.
                Cítíš, že rituál je téměř dokončen.
                Duch je silnější.
                """);
        }
        if (s.rychle) {
            System.out.println("""
                Díky včasnému příchodu je rituál ještě slabý.
                Duch není plně probuzen.
                """);
        }
        if (!s.slabina) {
            System.out.println("""
                Zpěv tě obklopí.
                Nevíš kdy… ale začneš mu naslouchat.
                Jen na okamžik zaváháš.
                To ale stačí.
                Je ještěsilnější.
                """);
        }
        if (s.zraneny) {
            System.out.println("Zranění ti ztěžuje pohyb v boji.");
        }
        if (s.slabina) {
            System.out.println("""
                Zpěv sílí.
                Snaží se dostat do tvé mysli.
                Ale ty si vzpomeneš na slova zraněného.
                Neodpovídáš.
                Něco se zlomí.
                Jeho síla slábne.
                """);
        }
        if (s.spojenec) {
            System.out.println("Spojenec se objeví a pomůže ti v rozhodující chvíli, jak slíbil.");
        }

        if (s.ochrana) {
            System.out.println("Temná síla na tebe nefunguje. Nelze tě ovládnout.");
        }

    }

    static void konec() {
        oddelit();
        System.out.println();

        int vyhody = 0;

        //ve vesnici
        //if (s.duvera) vyhody++;
        //if (s.opatrnost) vyhody++;
        //když půjdeš po cestě
        if (s.spojenec) vyhody++;
        if (s.slabina) vyhody++;
        //když půjdeš mimo cestu - nejde mít obě výhody
        if (s.ochrana) vyhody++;
        if (s.tajnyVstup) vyhody++;
        //když půjdeš za zvuky
        if (s.rychle) vyhody++;
        //při vstupu do jeskyně
        if (s.priprava) vyhody++;

        if (vyhody == 3) {
            end("DOBRÝ KONEC");
            System.out.println("""
                    Zastavíš rituál dřív, než je dokončen.
                    
                    Odoláš zpěvu
                    a narušíš sílu, která ovládala les.
                    
                    Kult se rozpadne
                    a zajatci jsou zachráněni.
                    
                    Když odcházíš z lesa,
                    cítíš, že jeho vliv zeslábl.
                    
                    Lidé ve vesnici budou konečně v bezpečí.
                    
                    Tentokrát jsi vyhrál.
                    """);
        } else if (vyhody == 2) {
            end("SMÍŠENÝ KONEC");
            System.out.println("""
                    Podaří se ti rituál přerušit.
                    
                    Zpěv utichne
                    a kult se rozpadne.
                    
                    Přežiješ.
                    
                    Ale ne všechno dopadlo dobře.
                    
                    Některé lidi už zachránit nešlo
                    a les stále působí neklidně.
                    
                    Možná jsi problém zastavil —
                    ale ne úplně vyřešil.
                    
                    Je možné, že se znovu vrátí.
                    """);
        } else {
            end("ŠPATNÝ KONEC");
            System.out.println("""
                    Neodoláš zpěvu.
                
                    Nejdřív ho jen posloucháš,
                    ale postupně mu začneš věřit.

                    Než si to uvědomíš,
                    uděláš přesně to, co chce.

                    Ztratíš kontrolu nad sebou.

                    Kult tě přijme mezi sebe —
                    ne jako rovnocenného člena,
                    ale jako další nástroj.

                    Lidé ve vesnici budou dál mizet.

                    I proto, že jsi nepomohl.
                    """);
        }
        ramecek("""
            Co chceš udělat dál?
            
            1 - Hrát znovu
            2 - Konec
            """);

        int c = volba(2);

        if (c == 1) {
            System.out.println("""
                    
                    
                    
                    
                    """);
            s = new Stav();
            main();
        } else {
            System.exit(0);
        }
    }


    //rozhodování o pokračování
    static int volba(int max) {
        int x;

        while (true) {
            if (sc.hasNextInt()) {
                x = sc.nextInt();
                sc.nextLine();

                if (x >= 1 && x <= max) return x;
            } else {
                sc.nextLine();
            }

            System.out.println("Zadej číslo " + 1 + "-" + max);
        }
    }
    static void ramecek(String text) {
        String[] lines = text.split("\n");
        int max = 0;

        for (String l : lines) {
            if (l.length() > max) max = l.length();
        }

        String border = "_".repeat(max + 4);

        System.out.println(" " + border);
        for (String l : lines) {
            System.out.println("|  " + l + " ".repeat(max - l.length()) + "  |");
        }
        System.out.println(" " + border);
    }


    static void oddelit() {
        System.out.println("===============================================================================");
    }


    static void end(String text) {
        System.out.println("=== " + text + " ===");
    }
}