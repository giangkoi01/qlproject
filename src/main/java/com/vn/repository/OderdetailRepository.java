package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entity.OrderDetailPK;
import com.vn.entity.Orderdetail;

public interface OderdetailRepository extends JpaRepository<Orderdetail, OrderDetailPK>{

}
