package service;

import java.util.List;

import model.dto.TodoDTO;

public interface TodoListService {
	// 1. 查詢所有 TodoDTO 資料
	List<TodoDTO> findAllTodos();
	
	// 2. 查詢單筆 TodoDTO 資料
	TodoDTO geTodo(Integer id);
	
	// 3. 新增 TodoDTO 資料
	void addTodo(String text, Boolean completed);
	
	// 4. 修改指定 TodoDTO completed 完成與否
	void updateTodoComplete(Integer id, Boolean completed);
	
	// 5. 修改指定 TodoDTO Text 工作項目
	void updateTodoText(Integer id, String text);
	
	// 6. 刪除指定 TodoDTO 紀錄 
	void deleteTodo(Integer id);
}
