package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public interface MarkDAO {

    public Mark saveMark (Mark mark);
    public Mark updateMark(Mark mark);
    public Mark saveOrUpdateMark(Mark mark);
    public boolean deleteMark(Mark mark);
    public Mark getMarkById(int courseId);
    public List<Mark> getAllMarks();



}
