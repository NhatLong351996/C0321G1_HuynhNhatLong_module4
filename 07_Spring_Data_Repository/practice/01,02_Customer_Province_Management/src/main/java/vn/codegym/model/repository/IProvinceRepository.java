package vn.codegym.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.bean.Province;
@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
