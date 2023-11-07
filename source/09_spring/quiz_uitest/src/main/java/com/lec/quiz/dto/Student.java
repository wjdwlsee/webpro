package com.lec.quiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double evg;

	public int tot() {
		return kor+eng+mat;
	}
	public double evg() {
		return tot()/3.0d;
	}
}
