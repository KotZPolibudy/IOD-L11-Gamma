# IOD-L11-Gamma
For building administrators who want to optimize building management costs, our Building Info application will enable the acquisition of information about building parameters at the level of rooms, floors and entire buildings. The application will be available through a GUI and also as a remote API so it can be integrated with existing tools.

# General Info
- Lacation is a Building, a Floor, or a Room
- Building has a list of Floors, each of which have a list of rooms on corresponding floor 
- Each location has:
   * number (int) - a unique Number (Roomnumber, Floornumber, Buildingnumber)
- a room has also these parameters:
   * SurfaceArea = rooms surface in m^2
   * Volume - rooms volume
   * LightIntensity – How bright the room is
   * EnergyConsumption - How energy consuming the room is

# Contributors

- PPO - Wojciech 'KotZPolibudy' Kot: 151879
- Scrum Master - Kamil 'GaussX0' Małecki: 151861
- Developer - Oskar 'kilianczyko' Kiliańczyk: 151863 
- Developer - Mikołaj 'MNOWAK1234' Nowak: 151813

# Continuous Integration server status
![ci status](https://github.com/KotZPolibudy/IOD-L11-Gamma/actions/workflows/ci.yml/badge.svg)



# PL - IOD-L11-Gamma
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

# Ogólne informacje
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
  * numer – numer pokoju, unikalny identyfikator
- Pomieszczenie dodatkowo jest charakteryzowane przez:
  * Surface = powierzchnia w m^2
  * Volume = kubatura pomieszczenia w m^3
  * LightIntensity – natężenie oświetlenia w danym miejscu
  * EnergyConsumption = poziom zużycia energii ogrzewania


# Współautorzy

- PO Właściciela produktu - Wojciech 'KotZPolibudy' Kot: 151879
- Scrum Master - Kamil 'GaussX0' Małecki: 151861
- Deweloper - Oskar 'kilianczyko' Kiliańczyk: 151863
- Deweloper - Mikołaj 'MNOWAK1234' Nowak: 151813

# Status serwera ciągłej integracji
![ci status](https://github.com/KotZPolibudy/IOD-L11-Gamma/actions/workflows/ci.yml/badge.svg)
