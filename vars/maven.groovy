    def call(String repoUrl) {
        
        echo "${repoUrl}"
        
         //println(repoUrl)
        
        pipeline {
            agent any

           stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           } 
         
         stage("Checkout Code") {
               steps {
                   git branch: 'master',
                       url: "${repoUrl}"
               }
           }


        stage('Stability') {
          steps {
           sh '''mvn compile'''
        // sh '''mvn pmd:pmd'''
          }
          }
          
          stage('Quality') {
          steps {
           sh '''mvn checkstyle:checkstyle'''
         
          }
          }
                     
          stage('Code Coverage') {
          steps {
            sh '''mvn cobertura:cobertura'''
         
          }
          }
       }       
             
        }   
