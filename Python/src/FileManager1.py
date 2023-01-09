import json
import logging
from typing import List, Type, TypeVar, Any

T = TypeVar('T')

class FileManager1:
    def read_student(self, path: str) -> List[T]:
        logger = logging.getLogger(FileManager1.__name__)
        students = []
        gson = json.JSONEncoder(indent=2, sort_keys=True)
        directory_path = path
        file_list = directory_path.listdir()

        for file in file_list:
            try:
                with open(file.abs_path, 'r') as reader:
                    students_type = Type[T]
                    students.append(gson.from_json(reader, students_type))
            except Exception as e:
                print(e)

        logger.info(f'{len(students)} Student objects created.')
        return students

    def read_course(self, path: str) -> List[T]:
        try:
            gson = json.JSONEncoder(indent=2, sort_keys=True)
            with open(path, 'r') as reader:
                course_type = Type[List[T]]
                return gson.from_json(reader, course_type)
        except Exception as e:
            print(e)
        return None

    def read_student1(self, path: str) -> List[T]:
        try:
            gson = json.JSONEncoder(indent=2, sort_keys=True)
            with open(path, 'r') as reader:
                student_type = Type[List[T]]
                return gson.from_json(reader, student_type)
        except Exception as e:
            print(e)
        return None

    def read_lecturers(self, path: str) -> List[T]:
        logger = logging.getLogger(FileManager1.__name__)
        try:
            gson = json.JSONEncoder(indent=2, sort_keys=False)
            with open(path, 'r') as reader:
                lecturer_type = Type[List[T]]
                lecturers = gson.from_json(reader, lecturer_type)
                logger.info(f'{len(lecturers)} lecturer is read and lecturer objects created.')
                return lecturers
        except Exception as e:
            print(e)
        return None

    def read_params(self, path: str) -> dict[str, str]:
        logger = logging.getLogger(FileManager1.__name__)
        try:
            gson = json.JSONEncoder(indent=2, sort_keys=True)
            with open(path, 'r') as reader:
                class_type = Type[dict[str, str]]
                logger.info('Parameters are read and initialized.')
                return gson.from_json(reader, class_type)
        except Exception as e:
            print(e)
        return None

    def write_to_file(student: T, file_path: str) -> None:
        logger = logging.getLogger(FileManager1.__name__)
        try:
            file = file_path
            gson = json.JSONEncoder(indent=2, sort_keys=True, ensure_ascii=True)
            with open(file, 'w') as file_writer:
                json.dump(student, file_writer, default=lambda o: o.__dict__)
        except Exception as e:
            print(e)
        logger.info(f'{student.student_id}.json is created.')

    def write_to_file_with_array(student: List[T], file_path: str) -> None:
        try:
            file = file_path
            gson = json.JSONEncoder(indent=2, sort_keys=True, ensure_ascii=True)
            with open(file, 'w') as file_writer:
                json.dump(student, file_writer, default=lambda o: o.__dict__)
        except Exception as e:
            print(e)
