package ru.otus.project.rnis.simulator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObjectInfo {
    private Long oid;                                     // Уникальный идентификатор объекта в БД для которого предоставлена информация
    private String name;                                  // Имя объекта
    private String imei;                                  // IMEI объекта
    private Long cid;                                     // ID компании, к которой принадлежит объект
    private Instant dt;                                   // Дата и время в UTC (формат yyyy-MM-dd HH:mm:ss) поступления последнего сообщения от объекта (но не позднее чем переданный параметр dt), из этого сообщения и предыдущих будет представлена информация в ответе
    private List<Property> properties;                    // !!! Номер телефона получаем из этого списка, наименование свойства - Телефонный номер. !!! Список параметров объекта - те, которые отмечены для отображения в информации.
    private List<Sensor> sensors;                         // !!! Скорость получаем из этого списка, наименование - Скорость. !!! Список значений для каждого из датчиков объекта
    private String result;                                // Результат выполнения запроса. "Ok" - если запрос выполнен успешно, или текст ошибки
    private Long parentId;                                // Идентификатор в базе данных родительской группы объекта
    private String address;                               // Адрес
    private String objIcon;                               // Имя файла иконки для отображения объекта на карте (все файлы с иконками доступны по адресу [адрес сервера]/icons/objects/[имя файла])
    private Integer objIconHeight;                        // Высота иконки объекта в пикселях
    private Integer objIconWidth;                         // Ширина иконки объекта в пикселях
    private Boolean objIconRotate;                        // Признак необходимости поворачивать иконку объекта на карте при изменении направления его движения (true - поворачивать, false - не поворачивать)
    private Integer status;                               // Текущий статус объекта (наиболее критичное незакрытое событие). Возможные варианты: 1 - Критичное, 2 - Серьезное, 3 - Несущественное, 4 - Информационное, 5 - Нормальное
    private Double lat;                                   // Широта местоположения объекта в формате градусы – доли градусов
    private Double lon;                                   // Долгота местоположения объекта в формате градусы – доли градусов
    private Double direction;                             // Направление движения объекта в градусах относительно севера
    private Integer move;                                 // Текущий статус перемещения объекта. Возможные варианты: 110 - стоянка, связь есть; 111 - движение, связь есть; 101 - нет связи, до потери связи двигался; 100 - нет связи, до потери связи стоял; 200 - в последнем сообщении GPS не валиден, сейчас нет связи, до этого стоял; 201 - в последнем сообщении GPS не валиден, сейчас нет связи, до этого двигался; 210 - GPS не валиден, связь есть, до этого стоял; 211 - GPS не валиден, связь есть, до этого двигался; 666 - Объект заблокирован за неуплату; 667 - Объект заблокирован пользователем(ручная блокировка)
    private Integer blockReason;                          // Причина блокировки объекта. Возможные варианты: 0 - не заблокирован; 1 - заблокирован пользователем(ручная блокировка); 2 - заблокирован за неуплату
}