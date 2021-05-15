package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.AnswerAlreadyExistsException;
import org.loose.fis.sre.exceptions.QuestionAlreadyExistsException;
import org.loose.fis.sre.model.Answer;
import org.loose.fis.sre.model.Question;

import java.util.ArrayList;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class AnswerService {

    private static ObjectRepository<Answer> answerRepository;
    private static Nitrite database;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("answer.db").toFile())
                .openOrCreate("test", "test");

        answerRepository = database.getRepository(Answer.class);
    }
    public static void addAnswer(int idQ , String answer) throws AnswerAlreadyExistsException {
        checkAnswerDoesNotAlreadyExist(idQ);
        answerRepository.insert(new Answer(idQ,answer));
    }
    public static void checkAnswerDoesNotAlreadyExist(int idQ) throws AnswerAlreadyExistsException {
        for (Answer a : answerRepository.find()) {
            if (Objects.equals(idQ, a.getIdQ()))
                throw new AnswerAlreadyExistsException(idQ);
        }
    }

    public static ArrayList<Answer> getAllAnswers() {
        ArrayList<Answer> list = new ArrayList<>();
        for(Answer a : answerRepository.find()) {
            list.add(a);
        }
        return list;
    }
    public static Answer getAnswer(int idQ){
        for(Answer a : answerRepository.find())
            if(Objects.equals(idQ, a.getIdQ()))
                return a;
        return null;


    }


}
