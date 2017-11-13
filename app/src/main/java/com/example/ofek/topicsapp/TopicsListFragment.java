package com.example.ofek.topicsapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import Adapters.TopicsAdapter;
import Entities.Topic;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicsListFragment extends Fragment {
    RecyclerView recyclerView;
    TopicsAdapter adapter;
    ArrayList<Topic> topics=new ArrayList<>();
    public TopicsListFragment() {
        setTopicsList();
    }

    private void setTopicsList() {
        topics.add(new Topic("LeBron James","LeBron Raymone James (/ləˈbrɒn/; born December 30, 1984) is an American professional basketball player for the Cleveland Cavaliers of the National Basketball Association (NBA). James has won three NBA championships, four NBA Most Valuable Player Awards, three NBA Finals MVP Awards, two Olympic gold medals, an NBA scoring title, and the NBA Rookie of the Year Award. He has also been selected to 13 NBA All-Star teams, 13 All-NBA teams, and six All-Defensive teams, is the Cavaliers' all-time leading scorer, and is the NBA career playoff scoring leader.\n" +
                "\n" +
                "James played high school basketball at St. Vincent–St. Mary High School in his hometown of Akron, Ohio, where he was highly promoted in the national media as a future NBA superstar. After graduating, he was selected by his home team, the Cleveland Cavaliers, as the first overall pick of the 2003 NBA draft. James led Cleveland to the franchise's first Finals appearance in 2007, ultimately losing to the San Antonio Spurs. In 2010, he left the Cavaliers for the Miami Heat in a highly publicized ESPN special titled The Decision. James spent four seasons with the Heat, reaching the Finals all four years and winning back-to-back championships in 2012 and 2013. In 2013, he led Miami on a 27-game winning streak, the third longest in league history. Following his final season with the Heat in 2014, James opted out of his contract and returned to the Cavaliers. From 2015 to 2017, he led the Cavaliers to three consecutive Finals, winning his third championship in 2016 to end Cleveland's 52-year professional sports title drought.\n" +
                "\n" +
                "Off the court, James has accumulated considerable wealth and fame from numerous endorsement contracts. His public life has been the subject of much scrutiny, and he has been ranked as one of America's most influential and popular athletes. He has been featured in books, documentaries, and television commercials. He also hosted the ESPY Awards, Saturday Night Live, and appeared in the 2015 film Trainwreck."));
        topics.add(new Topic("James Harden","James Edward Harden Jr. (born August 26, 1989) is an American professional basketball player for the Houston Rockets of the National Basketball Association (NBA). Harden played college basketball for Arizona State, where he was named a consensus All-American and Pac-10 Player of the Year in 2009. Harden was selected with the third overall pick in the 2009 NBA draft by the Oklahoma City Thunder.[1] In 2012, he was named NBA Sixth Man of the Year with the Thunder and helped the team reach the NBA Finals.\n" +
                "\n" +
                "Harden was traded to Houston prior to the 2012–13 NBA season. Upon joining the Rockets, Harden became one of the NBA's most prolific scorers and earned recognition as the best shooting guard in the NBA,[2][3] as well as one of the top overall players in the league.[4] He has earned All-Star nods five times, and has earned All-NBA Team honors four times as well – once to the All-NBA third team (2013) and three times to the All-NBA first team (2014, 2015 and 2017). In 2015, Harden was awarded the first National Basketball Players Association MVP Award, being voted by his peers as the league's most valuable player.[5]\n" +
                "\n" +
                "Harden is a two-time member of the United States national basketball team, winning gold medals in both the 2012 Summer Olympics and 2014 FIBA World Cup."));
        topics.add(new Topic("Kawhi Leonard","Kawhi Anthony Leonard (/kəˈwaɪ/, born June 29, 1991) is an American professional basketball player for the San Antonio Spurs of the National Basketball Association (NBA). He played two seasons of college basketball for San Diego State University before being selected with the 15th overall pick in the 2011 NBA draft by the Indiana Pacers. He was then traded to San Antonio on draft night. Leonard won an NBA Championship with the Spurs in 2014 and was named the NBA Finals Most Valuable Player. He is a two-time NBA Defensive Player of the Year, having won in 2015 and 2016, and is a two-time All-NBA First Team member."));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_topics_list, container, false);
        recyclerView=view.findViewById(R.id.topicsList);
        adapter=new TopicsAdapter(topics,getActivity());
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper=new LinearSnapHelper();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        snapHelper.attachToRecyclerView(recyclerView);

        return view;
    }

}
