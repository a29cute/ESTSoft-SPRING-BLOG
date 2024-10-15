package com.estsoft.springdemoproject.lombok;

import lombok.*;

import java.util.List;

/**
 * 롬복 적용해볼 People 클래스
 * -> 생성자, Getter, Setter 적용
 */
// POJO(Plain Object Java Object)
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class People {
    private final Long id;
    private final String name;
    private int age;
    private List<String> hobbies;

/*   @AllArgsConstructor 롬복 어노테이션으로 대체 가능 */
//    public People(Long id, String name, int age, List<String> hobbies) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.hobbies = hobbies;
//    }

/*   @Getter 롬복 어노테이션으로 대체 가능 */
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public List<String> getHobbies() {
//        return hobbies;
//    }

/*   @Setter 롬복 어노테이션으로 대체 가능 */
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setHobbies(List<String> hobbies) {
//        this.hobbies = hobbies;
//    }
}
