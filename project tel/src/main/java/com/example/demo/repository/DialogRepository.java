package com.example.demo.repository;

import com.example.demo.model.Dialog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DialogRepository extends CrudRepository<Dialog,Integer> {
    Iterable<Dialog> getDialogsByUser1OrUser2(Integer id,Integer id2);

    Dialog findDialogByUser1AndUser2(Integer id1,Integer id2);
}
