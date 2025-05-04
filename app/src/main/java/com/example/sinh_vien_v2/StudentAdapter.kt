package com.example.sinh_vien_v2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Student(val name: String, val mssv: String)

class StudentAdapter(
    private val students: MutableList<Student>
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // ViewHolder của từng item
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtStudent: TextView = itemView.findViewById(R.id.txtStudent)
        val txtMSSV: TextView = itemView.findViewById(R.id.txtMSSV)
    }

    // Tạo ViewHolder cho từng item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    // Bind dữ liệu cho từng item
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.txtStudent.text = student.name
        holder.txtMSSV.text = "MSSV: ${student.mssv}"
    }

    // Lấy tổng số item trong danh sách
    override fun getItemCount(): Int = students.size

    // Thêm sinh viên vào danh sách và thông báo cập nhật
    fun addStudent(student: Student) {
        students.add(student)
        notifyItemInserted(students.size - 1)  // Thông báo thêm một item mới
    }
}
