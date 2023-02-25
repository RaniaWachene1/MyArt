/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author rania
 */
public interface IService<T> {
// 
  void insert(T a);
   void delete(T a);
    void update(T a);
   List<T> readAll();
    T readById(int id);
//    

}
