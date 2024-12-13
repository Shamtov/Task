Создать микросервис для управления задачами с использованием Java 17, Spring Boot 3, JPA/Hibernate, Flyway, Spring Security, PostgreSQL и MapStruct. Микросервис должен реализовывать CRUD (Create, Read, Update, Delete) операции для сущности "Задача" с использованием REST API.

1. Технические требования
   Язык разработки: Java 17
   Фреймворк: Spring Boot 3
   База данных: PostgreSQL
   Инструменты для миграции БД: Flyway
   Обработка данных: JPA, Hibernate
   Авторизация и безопасность: Spring Security
   Преобразование данных: MapStruct
   API: RESTful
   Версия Java: 17 (поддержка новых возможностей Java 17)
   Библиотеки и зависимости: Maven или Gradle (по вашему выбору)
2. Описание сущности "Задача"
   Сущность "Задача" (Task) должна содержать следующие поля:

id (Long) – уникальный идентификатор задачи.
title (String) – заголовок задачи.
description (String) – описание задачи.
createdAt (LocalDateTime) – дата и время создания задачи.
updatedAt (LocalDateTime) – дата и время последнего обновления задачи.
status  – статус задачи. Возможные значения: PENDING, IN_PROGRESS, COMPLETED.
3. Функциональные требования
   CRUD-операции для задач:

Создание задачи (POST /tasks): возможность добавить новую задачу.
Получение всех задач (GET /tasks): получение списка всех задач.
Получение задачи по ID (GET /tasks/{id}): получение конкретной задачи по её ID.
Обновление задачи (PUT /tasks/{id}): обновление информации о задаче.
Удаление задачи (DELETE /tasks/{id}): удаление задачи по её ID.
Пользовательская аутентификация и авторизация:

Реализовать авторизацию с использованием Spring Security.
Использовать базовую аутентификацию (или JWT-токены) для защиты API.
Только аутентифицированные пользователи могут работать с задачами.
Миграция базы данных с помощью Flyway:

Создать необходимые миграции для инициализации схемы базы данных.
Пример миграции: создание таблицы задач с нужными колонками.
Маппинг сущностей с использованием MapStruct:

Для работы с сущностями и DTO (Data Transfer Object) использовать библиотеку MapStruct.
Создать DTO для задачи, которое будет использоваться при взаимодействии с клиентом.
Использование PostgreSQL:

Подключение к базе данных PostgreSQL.
Реализация репозитория для взаимодействия с базой данных через JPA и Hibernate.
4. Архитектура микросервиса
   Сущности (Entities):

Создать сущность Task, которая будет соответствовать таблице в базе данных.
DTO (Data Transfer Objects):

Создать DTO класс для Task, чтобы передавать данные по API.
Репозиторий (Repository):

Создать репозиторий TaskRepository для работы с сущностью Task, используя Spring Data JPA.
Сервис (Service):

Создать сервисный слой для бизнес-логики, например, TaskService, который будет обрабатывать запросы от контроллеров.
Контроллер (Controller):

Создать контроллер TaskController, который будет реализовывать REST API для обработки запросов.
Маппер (Mapper):

Создать интерфейс с использованием MapStruct для маппинга между сущностью Task и DTO.
5. Технические детали
   Spring Boot 3: Использовать версии зависимостей, совместимые с Spring Boot 3.
   JPA/Hibernate: Настроить правильную работу с JPA и Hibernate.
   PostgreSQL: Для разработки можно использовать PostgreSQL в локальной среде. Настроить подключение в application.properties.
   Flyway: Настроить Flyway для миграции базы данных (создание таблицы задач и схемы базы данных).
   Spring Security: Использовать базовую авторизацию через Spring Security. Можно реализовать простую аутентификацию с помощью UserDetailsService или JWT.
   MapStruct: Использовать MapStruct для маппинга между сущностями и DTO.
6. Дополнительные задания (опционально)
   Логирование: Настроить логирование с использованием SLF4J и Logback.
   Тестирование: Написать юнит-тесты для контроллеров и сервисов с использованием JUnit 5 и Mockito.
   Документация API: Настроить Swagger для документирования REST API.
   Обработка ошибок: Реализовать централизованную обработку ошибок с использованием @ControllerAdvice.
7. Пример миграции Flyway (SQL файл)
   Создайте миграцию с именем V1__create_tasks_table.sql:

sql
Копировать код
CREATE TABLE tasks (
id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description TEXT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
status VARCHAR(50) NOT NULL
);
8. Пример DTO
   java
   Копировать код
   public class TaskDTO {
   private Long id;
   private String title;
   private String description;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
   private String status;
   }
   11.Примечания

Все запросы к API должны быть защищены через Spring Security, только аутентифицированные пользователи могут совершать операции с задачами.
Для тестирования можно использовать Postman или любой другой инструмент для работы с REST API.