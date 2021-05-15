package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.QuestionAlreadyExistsException;
import org.loose.fis.sre.model.Question;

import java.util.ArrayList;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class QuestionService {

    private static ObjectRepository<Question> questionRepository;
    private static Nitrite database;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("question.db").toFile())
                .openOrCreate("test", "test");

        questionRepository = database.getRepository(Question.class);
    }
    public static void addQuestion(int idQ , String question) throws QuestionAlreadyExistsException {
        checkQuestionDoesNotAlreadyExist(idQ);
        questionRepository.insert(new Question(idQ,question));
    }
    public static void checkQuestionDoesNotAlreadyExist(int idQ) throws QuestionAlreadyExistsException {
        for (Question q : questionRepository.find()) {
            if (Objects.equals(idQ, q.getIdQ()))
                throw new QuestionAlreadyExistsException(idQ);
        }
    }

    public static ArrayList<Question> getAllQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        for(Question q : questionRepository.find()) {
            list.add(q);
        }
        return list;
    }
    public static Question getQuestion(int idQ){
        for(Question q : questionRepository.find())
            if(Objects.equals(idQ, q.getIdQ()))
                return q;
        return null;


    }


}
