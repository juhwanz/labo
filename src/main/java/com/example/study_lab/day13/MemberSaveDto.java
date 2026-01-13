package com.example.study_lab.day13;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MemberSaveDto {

    @NotBlank(message = "이름은 필수 입니다.") // null, "", " " 모두 허용 안함.
    private String name;

    @Min(value = 1, message = "나이는 1살 이상이어야 합니다.")
    private int age;

    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    // Getter, Setter, 생성자 (기본 생성자 포함)
    public MemberSaveDto(){}

    public MemberSaveDto(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName(){
        return name;}
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
}
