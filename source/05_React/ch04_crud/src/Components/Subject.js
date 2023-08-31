import { Component } from "react";

class Subject extends Component{
    render(){
        console.log('Subject rander');
        return(
            <header>
                <h1><a href="/" onClick={function(e){
                    e.preventDefault();
                    this.props.onChangePage();
                }.bind(this)}>
                    {this.props.title}
                    </a>
                </h1>
                {this.props.sub}
                <hr />
            </header>   
        );
    }
}
export default Subject;