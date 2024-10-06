package com.dto.demo.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.dto.demo.dtos.UserDto;
import com.dto.demo.models.Book;
import com.dto.demo.models.User;
import com.dto.demo.utils.enums.Degree;

public class EntityToDtoMapper {

    public static UserDto mapUserToUserDto(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return new UserDto(user.getId(), user.getName(), user.getEmail(),
            user.getAge(), user.getDegree().toString(), user.getStudentUrl().getUrl(),
            user.getBooks().stream().map(Book::getTitle).collect(Collectors.toList()), user.getDob().toLocalDate());
    }

    public static User mapUserDtoToUser(UserDto userDto) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setDegree(Degree.valueOf(userDto.getDegree()));
        user.setDob(Date.valueOf(userDto.getDob()));
//            Date date = sdf.parse(userDto.getDob());
//            user.setDob(new java.sql.Date(date.getTime()));
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
        return user;
    }

    public static void mapUserDtoToUser(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setDegree(Degree.valueOf(userDto.getDegree()));
    }
}
