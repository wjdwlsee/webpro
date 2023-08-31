import { Component } from "react";
import './Subject.css';
class Subject extends Component{
    render(){
        console.log('Subject render 수행;')
        return(
            <header>
            <h1>
                <a href="/" onClick={function(e){
                    e.preventDefault();
                    this.props.onChangePage();
                }.bind(this)}>
                    {this.props.title}
                </a>
            </h1>
            {this.props.sub}{/* 주석 */}
            </header>
            );
        }
    }
    export default Subject;