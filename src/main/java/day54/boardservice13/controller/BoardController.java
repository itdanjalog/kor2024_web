package day54.boardservice13.controller;

import day54.boardservice13.model.BoardDao;
import day54.boardservice13.model.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {

    // 1. 게시물 등록 제어 함수
    @PostMapping("/write")    // [POST] http://localhost:8080/write
    public boolean boardWrite( @RequestBody BoardDto boardDto ){
        System.out.println("boardDto = " + boardDto);
        return BoardDao.getInstance().boardWrite( boardDto );
    }
    /*
    {
        "content": "안녕하세요 첫번째 글",
        "writer": "유재석",
        "pwd": "1234"
        }
     */

    // 2. 게시물 출력 제어 함수
    @GetMapping("/print")   // [GET] http://localhost:8080/print
    public ArrayList<BoardDto> boardPrint( ){
        ArrayList<BoardDto> result = BoardDao.getInstance().boardPrint();

        return result;
    } // e end

    // 3. 게시물 삭제 controller 함수
    @DeleteMapping("/delete") // [DELETE] http://localhost:8080/delete?deleteNum=2
    public boolean boardDelete( int deleteNum ){
        boolean result  = BoardDao.getInstance().boardDelete( deleteNum );
        return result;
    } // m end

    // 4. 게시물 수정 controller 함수
    @PutMapping("/update")  // [PUT] http://localhost:8080/update
    public boolean boardUpdate( @RequestBody BoardDto updateDto ){
        boolean result = BoardDao.getInstance().boardUpdate( updateDto );
        return result;
    }
    /*
    {
      "content": "안녕하세요 4번째 글",
      "num" : 4
    }
     */
} // class end























