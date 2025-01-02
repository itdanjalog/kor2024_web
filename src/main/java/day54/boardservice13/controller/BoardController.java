package day54.boardservice13.controller;

import day54.boardservice13.model.dao.BoardDao;
import day54.boardservice13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// ============== 콘솔 =====================//
//public class BoardController {
//    // + 싱글톤
//    private static BoardController instance = new BoardController();
//    private BoardController(){}
//    public static BoardController getInstance(){return instance;}
//
//    // 1. 게시물 쓰기        [ CRUD 중에 C , HTTP METHOD 중에 POST ]
//    public boolean write( BoardDto boardDto){
//        boolean result = BoardDao.getInstance().write( boardDto );
//        return result;
//    }
//    // 2. 게시물 전체 조회    [ CRUD 중에 R , HTTP METHOD 중에 GET ]
//    public ArrayList<BoardDto> findAll( ){
//        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
//        return result;
//    }
//}

// ============== HTTP 웹 =====================//
@RestController // 현재 클래스에 rest api 가 가능한 클래스임을 주입한다.
// [1] 클래스 위에 @RestController
public class BoardController {

    // 1. 게시물 쓰기        [ CRUD 중에 C , HTTP METHOD 중에 POST ]
    // [2] 함수위에 @XXXXMapping("/주소만들기")
    // [TEST] Talend Api Tester : [POST] http://localhost:8080/write
    @PostMapping("/write")
    public boolean write( BoardDto boardDto){
        boolean result = BoardDao.getInstance().write( boardDto );
        return result;
    }
    // 2. 게시물 전체 조회    [ CRUD 중에 R , HTTP METHOD 중에 GET ]
    @GetMapping("/findall")
    // [TEST] Talend Api Tester : [GET] http://localhost:8080/findall
    public ArrayList<BoardDto> findAll( ){
        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
        return result;
    }
}



