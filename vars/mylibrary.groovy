def stability() {
    
    sh 'mvn compile'
     sh 'mvn pmd:pmd'
 }

def quality() {
    
    sh 'mvn checkstyle:checkstyle'
 }

def codecoverage() {
    
    sh 'mvn cobertura:cobertura'
 }


