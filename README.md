# IOD-L11-Gamma
For building administrators who want to optimize building management costs, our Building Info application will enable the acquisition of information about building parameters at the level of rooms, floors and entire buildings. The application will be available through a GUI and also as a remote API so it can be integrated with existing tools.

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
![ci status](https://github.com/KotZPolibudy/IOD-L11-Gamma/actions/workflows/ci.yml/badge.svg)
