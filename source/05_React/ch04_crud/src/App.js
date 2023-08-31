import { Component } from 'react';
import './App.css';
import Subject from './Components/Subject';
import TOC from './Components/TOC';
import ReadContent from './Components/ReadContent';
class App extends Component{
  constructor(props){
    super(props);
    this.state = {
      mode:'read',
      selected_content_id :3,
      Subject : {title: 'WEB', sub:'World wide Web !!'},
      contents : [
        {id:1, title : 'HTML',       desc:'HTML is for information'},
        {id:2, title : 'CSS',        desc:'CSS is for design'},
        {id:3, title : 'JavaScript', desc:'JavaScript is for interactive'},  
        {id:4, title : "React",      desc:"React is for UI" }
      ],
      welcome : {title:'Welcome', desc:'Hello, React'},
    };
  }
  render(){
    console.log('App rander');
    var _title, _desc,_article = null;
    if(this.state.mode ==='welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article =<ReadContent title={_title} desc={_desc}></ReadContent>
    }else if(this.state.mode === 'read'){
      // _title = this.state.contents[0].title;
      // _desc = this.state.contents[0].desc;
    for(var i=0; i<this.state.contents.length ; i+ i++){
      var data = this.state.contents[i];
      if(data.id === this.state.selected_content_id){
        _title = data.tilte;
        _desc = data.desc;
        break;
      }
    }
    _article = <ReadContent title={_title} desc={_desc}></ReadContent>
  }
    return (
      <div>
      <Subject  title = {this.state.Subject.title}
                  sub={this.state.Subject.sub}
                  onChangePage={function(){
                      this.setState({
                      mode : 'welcome'
                    });
                  }.bind(this)}></Subject>
      <TOC data={this.state.contents}
            onChangePage={function(id){
              this.setState({
                mode:'read',
                selected_content_id : Number(id),
              });
            }.bind(this)}> </TOC>
          {_article}
      </div>   
    );
  }
}
export default App;
