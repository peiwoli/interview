import React from "react";
import logo from './logo.svg';
import './App.css';

class App extends React.Component {

   // Constructor 
   constructor(props) {
    super(props);

    this.state = {
        data: [],
        DataisLoaded: false
    };
  }
  componentDidMount() {
    console.log('fetchPDFData....');
    fetch('http://localhost:8080/get_text')
    .then(response => response.json())
    .then(data =>  {
      this.setState({
                    items: data.data,
                    DataisLoaded: true
                });
    });
}

  // var isLoaded = false;
  // console.log('fetchPDFData');
  // fetch('http://localhost:8080/get_text')
  // .then(response => response.json())
  // .then(data =>  {
  //   console.log(data);
  //   isLoaded = true;
  // });

  render() {
    const { DataisLoaded, items } = this.state;

    if (!DataisLoaded) return <div>
            <h1> Pleses wait some time to load PDF file.... </h1> </div> ;

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div dangerouslySetInnerHTML={{__html: items}} />         
        </header>
      </div>
    );
  }
  
}

export default App;
