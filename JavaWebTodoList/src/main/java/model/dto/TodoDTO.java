package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.Todo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
	private Integer id; // 序號 Integer 初始值為null  int 初始值為 0
	private String text; // 工作項目
	private Boolean completed; // 項目是否完成?
}

