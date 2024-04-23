const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmu5y49/",
            name: "ssmu5y49",
            // quit 到Home page链接
            indexUrl: 'http://localhost:8080/ssmu5y49/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "Online music site"
        } 
    }
}
export default base
