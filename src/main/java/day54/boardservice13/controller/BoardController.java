package day54.boardservice13.controller;

import day54.boardservice13.model.dao.BoardDao;
import day54.boardservice13.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {

    // + 싱글톤
    private static BoardController instance = new BoardController();
    private BoardController(){}
    public static BoardController getInstance(){return instance;}

    // 1. 게시물 쓰기
    public boolean write(BoardDto boardDto){
        boolean result = BoardDao.getInstance().write( boardDto );
        return result;
    }
    // 2. 게시물 전체 조회
    public ArrayList<BoardDto> findAll( ){
        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
        return result;
    }

    // 3. 게시물 개별 조회


    // 4. 게시물 수정


    // 5. 게시물 삭제

}
