package com.moontomi.server.api.content

import com.moontomi.server.core.lecture.LectureCreationRequest
import com.moontomi.server.core.lecture.LectureDto
import com.moontomi.server.core.lecture.LectureService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LectureController(
    private val lectureService: LectureService
): AbstractContentController() {
    @GetMapping("/lectures.v1")
    fun getLectures(): List<LectureDto> {
        return lectureService.findAll()
    }

    @GetMapping("/lecture/{lectureId}.v1")
    fun getLecture(@PathVariable lectureId: Int): LectureDto {
        return lectureService.findById(lectureId)
    }

    @PostMapping("/lecture.v1")
    fun postLecture(@RequestBody request: LectureCreationRequest): LectureDto {
        return lectureService.insert(request)
    }
}