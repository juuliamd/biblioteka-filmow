# Biblioteka Filmów
Aplikacja webowa do zarządzania biblioteką filmów. Projekt ten wykorzystuje Spring Boot do tworzenia API REST umożliwiającego zarządzanie filmami: dodawanie, edytowanie, usuwanie oraz wyszukiwanie filmów.

### Funkcjonalności
- [x] **Wyświetlanie wszystkich filmów:** Paginacja listy filmów.
- [x] **Dodawanie nowego filmu:** Dodanie nowego filmu do bazy danych.
- [x] **Edycja istniejącego filmu:** Aktualizacja informacji o filmie na podstawie jego ID.
- [x] **Usuwanie filmu:** Usunięcie filmu na podstawie jego ID.
- [x] **Wyszukiwanie filmów po tytule:** Wyszukiwanie filmów zawierających określony tytuł (case insensitive).
- [x] **Filtrowanie filmów po gatunku:** Filtrowanie filmów według określonego gatunku.
- [x] **Sortowanie filmów po ocenie:** Sortowanie filmów według oceny w kolejności rosnącej lub malejącej.
- [x] **Filtrowanie filmów po obejrzeniu:** Filtrowanie filmów według statusu obejrzenia.


## Instalacja

1. Sklonuj repozytorium:

    ```bash
    git clone https://github.com/twoje-repozytorium/biblioteka-filmow.git
    ```

2. Przejdź do katalogu projektu:

    ```bash
    cd biblioteka-filmow
    ```

3. Zbuduj projekt za pomocą Maven:

    ```bash
    mvn clean install
    ```

4. Uruchom aplikację:

    ```bash
    mvn spring-boot:run
    ```

## Endpointy API

### Wyświetlanie wszystkich filmów

- **URL**: `/api/films`
- **Metoda**: `GET`
- **Parametry zapytania**:
  - `page` (opcjonalny, domyślnie `0`): Numer strony.
  - `size` (opcjonalny, domyślnie `10`): Rozmiar strony.
- **Przykład**:
    ```bash
    curl -X GET "http://localhost:8080/api/films?page=0&size=10"
    ```

### Dodawanie nowego filmu

- **URL**: `/api/films`
- **Metoda**: `POST`
- **Body**: JSON zawierający dane filmu.
- **Przykład**:
    ```bash
    curl -X POST "http://localhost:8080/api/films" -H "Content-Type: application/json" -d '{"title":"Inception","releaseYear":2010,"genre":"Sci-Fi","watched":true,"rating":9,"review":"Great movie"}'
    ```

### Edycja istniejącego filmu

- **URL**: `/api/films/{id}`
- **Metoda**: `PUT`
- **Parametry**: `id` - ID filmu do zaktualizowania.
- **Body**: JSON zawierający zaktualizowane dane filmu.
- **Przykład**:
    ```bash
    curl -X PUT "http://localhost:8080/api/films/1" -H "Content-Type: application/json" -d '{"title":"Inception","releaseYear":2010,"genre":"Sci-Fi","watched":true,"rating":10,"review":"Excellent movie"}'
    ```

### Usuwanie filmu

- **URL**: `/api/films/{id}`
- **Metoda**: `DELETE`
- **Parametry**: `id` - ID filmu do usunięcia.
- **Przykład**:
    ```bash
    curl -X DELETE "http://localhost:8080/api/films/1"
    ```

### Wyszukiwanie filmów po tytule

- **URL**: `/api/films/search`
- **Metoda**: `GET`
- **Parametry zapytania**: `title` - Tytuł filmu do wyszukania.
- **Przykład**:
    ```bash
    curl -X GET "http://localhost:8080/api/films/search?title=Inception"
    ```

### Filtrowanie filmów po gatunku

- **URL**: `/api/films/filter`
- **Metoda**: `GET`
- **Parametry zapytania**: `genre` - Gatunek filmów do filtrowania.
- **Przykład**:
    ```bash
    curl -X GET "http://localhost:8080/api/films/filter?genre=Sci-Fi"
    ```

### Sortowanie filmów po ocenie

- **URL**: `/api/films/sort`
- **Metoda**: `GET`
- **Parametry zapytania**: `direction` - Kierunek sortowania (`asc` lub `desc`).
- **Przykład**:
    ```bash
    curl -X GET "http://localhost:8080/api/films/sort?direction=asc"
    ```

### Filtrowanie filmów po obejrzeniu

- **URL**: `/api/films/watched`
- **Metoda**: `GET`
- **Parametry zapytania**: `watched` - Status obejrzenia (`true` lub `false`).
- **Przykład**:
    ```bash
    curl -X GET "http://localhost:8080/api/films/watched?watched=true"
    ```

## Autor

- Twoje Imię i Nazwisko

## Licencja

Ten projekt jest licencjonowany na warunkach licencji MIT - zobacz plik [LICENSE](LICENSE) aby uzyskać więcej informacji.
