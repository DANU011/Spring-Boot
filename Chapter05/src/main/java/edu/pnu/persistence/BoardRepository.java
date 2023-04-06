package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	
	
	List<Board> findByTitleContaining(String searchKeyword);
	List<Board> findByTitleContainingAndCntGreaterThan(String searchKeyword,Long cnt);
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqual(Long cnt_l,Long cnt_g);
	List<Board> findByCntBetweenOrderBySeqAsc(Long cnt_l,Long cnt_g);
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title,String con);
	
	
	
	//List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	@Query("select b from Board b")
	List<Board> queryAnnotationTest(Pageable paging);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	@Query("select b seq, b.title, b.createDate "
			+ "from Board b "
			+ "where b.title like %?1% "
			+ "order by b.seq desc")
	List<Object[]> queryAnnotationTest2(@Param("serchKeyword") String serchKeyword);
	
	@Query(value="select seq, title, writer, create_date "
			+ "from Board where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest3(String serchKeyword);
	
}
