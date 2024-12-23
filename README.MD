# Student System

## Beskrivning
Det här är ett menybaserat program som fungerar som ett studenthanteringssystem för en liten skola. Programmet hanterar studentuppgifter som ID, namn och betyg och erbjuder funktioner för att lägga till, söka, visa och spara/läsa studentposter till och från en fil.

Programmet är designat med hjälp av **Singleton-mönstret** och använder en **HashMap** för att lagra studentuppgifter.

---

## Funktionalitet
### Funktionella krav som uppfylls:
1. **Lägg till studentuppgifter**
    - Lägger till en student med unikt ID, namn och betyg.
2. **Spara poster till fil**
    - Alla poster sparas till en fil kallad `students.txt`.
3. **Läs poster från fil**
    - Studentposter kan laddas från en fil till minnet.
4. **Sök student via ID**
    - Möjligheten att hitta en student baserat på deras unika ID.
5. **Visa alla studenter**
    - Visar alla studentposter som lagras i minnet.
6. **Avsluta programmet**
    - Programmet kan avslutas utan att förlora poster som är sparade i filen.

---

## Datastruktur: Varför `HashMap`?

### Val av datastruktur
För att lagra studentuppgifterna har vi valt att använda en **HashMap**. Detta beror på:

1. **Effektivitet:**
    - `HashMap` erbjuder snabb åtkomst för sökning, inläggning och borttagning.
    - Detta gör det mycket effektivare än en **LinkedList** eller **ArrayList**, som båda kräver mer för att hitta en specifik student baserat på ID.

2. **Unika nycklar:**
    - `HashMap` använder nyckel kopplad till värde, där studentens ID fungerar som en unik nyckel.
    - Detta säkerställer att inga duplicerade ID:n kan läggas till i systemet.

3. **Flexibilitet:**
    - `HashMap` expanderar dynamiskt när fler poster läggs till, utan att vi manuellt behöver hantera storleken som med en vanlig array.

---

## Programstruktur

### Klasser och deras ansvar

1. **`Student`**
    - Representerar en studentpost.
    - Attribut: `id`, `name`, `grade`.
    - Inkluderar metoder för att hämta studentens uppgifter och en `toString` för utskrift.

2. **`StudentManager`** 
    - Hanterar lagringen av studentposter med hjälp av en `HashMap`.
    - Funktioner:
        - Lägga till en student.
        - Söka efter en student via ID.
        - Hämta alla studenter.

3. **`FileHandler`**
    - Ansvarar för filhantering:
        - Spara alla studentposter till fil.
        - Ladda studentposter från fil till minnet.

4. **`StudentSystem`**
    - Implementerar **Singleton-mönstret** för att säkerställa att endast en instans av systemet existerar.
    - Tillhandahåller ett användarvänligt konsolgränssnitt.
    - Koordinerar funktionerna mellan `StudentManager` och `FileHandler`.

5. **`Application`**
    - Startpunkt för programmet.
    - Initierar och kör `StudentSystem`.

---

## Så här fungerar programmet

1. När programmet startas initieras `StudentSystem` som en Singleton.
2. Användaren presenteras med en meny med olika alternativ:
    - Lägga till en ny student.
    - Spara studentposter till en fil.
    - Ladda studentposter från en fil.
    - Sök efter en specifik student med deras ID.
    - Visa alla studenter som är sparade i minnet.
    - Avsluta programmet.
3. Alla studentposter lagras i en `HashMap` under körning och kan sparas till eller laddas från fil.
4. Programmet använder sig av klara gränssnitt mellan klasserna för att hålla logiken lättförståelig.

---

## Krav
- **Java 8 eller senare**
- En texteditor eller IDE för att köra programmet (t.ex. IntelliJ IDEA, Eclipse, eller VS Code).

---

## Hur man kör programmet

1. Klona eller ladda ner källkoden.
2. Kör filen `Application.java` i en IDE.
3. Följ instruktionerna i konsolen för att använda programmet.

---

## Framtida förbättringar
- Lägga till fler funktioner, t.ex. att uppdatera en students uppgifter.
- Använda en databas istället för en fil för att hantera data.
- Implementera en grafisk användargränssnitt (GUI) för att göra systemet mer användarvänligt.
