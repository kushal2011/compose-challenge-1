package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.models.PuppyModel

object PuppiesRepository {
    fun fetchPuppies():ArrayList<PuppyModel>{
        val puppiesList:ArrayList<PuppyModel> = ArrayList()
        puppiesList.add(PuppyModel(name = "Tommy",age = 0.3,breed = "German Shepherd",isMale = true,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d0/German_Shepherd_-_DSC_0346_%2810096362833%29.jpg"))
        puppiesList.add(PuppyModel(name = "Timmy",age = 0.1,breed = "Poddle",isMale = false,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/f/f8/Full_attention_%288067543690%29.jpg"))
        puppiesList.add(PuppyModel(name = "Tim",age = 1.3,breed = "Bulldog",isMale = true,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/1/11/Bulldog_adult_male.jpg"))
        puppiesList.add(PuppyModel(name = "Jimmy",age = 1.0,breed = "Labrador Retriever",isMale = false,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/3/34/Labrador_on_Quantock_%282175262184%29.jpg"))
        puppiesList.add(PuppyModel(name = "Jim",age = 0.9,breed = "Golden Retriever",isMale = false,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/9/93/Golden_Retriever_Carlos_%2810581910556%29.jpg"))
        puppiesList.add(PuppyModel(name = "Jimbo",age = 3.0,breed = "German Shepherd",isMale = true,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d0/German_Shepherd_-_DSC_0346_%2810096362833%29.jpg"))
        puppiesList.add(PuppyModel(name = "Timmy",age = 0.1,breed = "Poddle",isMale = false,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/f/f8/Full_attention_%288067543690%29.jpg"))//repeated from this line
        puppiesList.add(PuppyModel(name = "Tim",age = 1.3,breed = "Bulldog",isMale = true,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/1/11/Bulldog_adult_male.jpg"))
        puppiesList.add(PuppyModel(name = "Jimmy",age = 1.0,breed = "Labrador Retriever",isMale = false,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/3/34/Labrador_on_Quantock_%282175262184%29.jpg"))
        puppiesList.add(PuppyModel(name = "Jim",age = 0.9,breed = "Golden Retriever",isMale = false,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/9/93/Golden_Retriever_Carlos_%2810581910556%29.jpg"))
        puppiesList.add(PuppyModel(name = "Jimbo",age = 3.0,breed = "German Shepherd",isMale = true,imgUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d0/German_Shepherd_-_DSC_0346_%2810096362833%29.jpg"))

        return puppiesList
    }
}