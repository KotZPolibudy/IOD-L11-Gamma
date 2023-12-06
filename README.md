# IOD-L11-Gamma
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

# General Info
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
   * id – unikalny identyfikator
   * name – opcjonalna nazwa lokalizacji
- Pomieszczenie dodatkowo jest charakteryzowane przez:
   * area = powierzchnia w m^2
   * cube = kubatura pomieszczenia w m^3
   * heating = poziom zużycia energii ogrzewania (float)
   * light – łączna moc oświetlenia


# Contributors

- PPO - Wojciech 'KotZPolibudy' Kot : 151879
- Scrum Master - Kamil 'GaussX0' Małecki : 151861
- Developer - Oskar 'kilianczyko' Kiliańczyk : 151863 
- Developer - Mikołaj 'MNOWAK1234' Nowak : 151813

# Continuous Integration server status
![workflow status](https://github.com/KotZPolibudy/IOD-L11-Gamma/blob/main/.github/workflows/ci.yml/badge.svg)
